package com.blog.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.blog.orm.Album;
import com.blog.orm.Photo;
import com.blog.orm.Userinfo;
import com.blog.service.AlbumManager;
import com.blog.service.UserManagerService;
import com.opensymphony.xwork2.ActionSupport;

public class AlbumAction extends ActionSupport {
	
	private static final long serialVersionUID = 7168800737187806628L;
	private static final int BUFFER_SIZE = 1024*16;
	private AlbumManager<Album> albumService;
	private UserManagerService<Userinfo> userService;
	private List<Album> allist;
	private Set<Photo> plist;
	private File  album;
	private String albumFileName;
	private String albumContentType;
	private String savePath;
	
	public String getAlbumContentType() {
		return albumContentType;
	}


	public void setAlbumContentType(String albumContentType) {
		this.albumContentType = albumContentType;
	}

	public String getSavePath() {
		return savePath;
	}


	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}


	public File getAlbum() {
		return album;
	}


	public void setAlbum(File album) {
		this.album = album;
	}


	public String getAlbumFileName() {
		return albumFileName;
	}


	public void setAlbumFileName(String albumFileName) {
		this.albumFileName = albumFileName;
	}


	public List<Album> getAllist() {
		return allist;
	}


	public void setAllist(List<Album> allist) {
		this.allist = allist;
	}


	public Set<Photo> getPlist() {
		return plist;
	}


	public void setPlist(Set<Photo> set) {
		this.plist = set;
	}


	public AlbumManager<Album> getAlbumService() {
		return albumService;
	}


	public void setAlbumService(AlbumManager<Album> albumService) {
		this.albumService = albumService;
	}


	public UserManagerService<Userinfo> getUserService() {
		return userService;
	}


	public void setUserService(UserManagerService<Userinfo> userService) {
		this.userService = userService;
	}
	
	public String addAlbum(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("pageshow","albumadd");
		
		return "add";
	}
	
	public String  addctionAlbum(){
	     String dstPath = ServletActionContext.getServletContext()
	             .getRealPath(this.getSavePath())
	             + "\\" + this.getAlbumFileName();
	     System.out.println(dstPath);
	     File imageFile = new File(dstPath);
	     saveIn(album, imageFile);
		
		 Album abtemp = new Album();
		 abtemp.setAuthor("admin");
		 String abname=ServletActionContext.getRequest().getParameter("abname");
		 abtemp.setAlbumname(abname);
		 abtemp.setAlbumsize(0);
		 abtemp.setAlbumtumb(this.getAlbumFileName());
		 abtemp.setPosttime(new Date());
		 try {
			 albumService.doAddAlbum(abtemp);
		  } catch (Exception e) {
			   e.printStackTrace();
			   return "error";
	      }
		 return "success";
	}
	/*
	 * 保存文件
	 */
	private void saveIn(File src, File dst) {
		
		try {
            InputStream in = null ;
            OutputStream out = null ;
             try {                
                in = new BufferedInputStream( new FileInputStream(src), BUFFER_SIZE);
                out = new BufferedOutputStream( new FileOutputStream(dst), BUFFER_SIZE);
                 byte [] buffer = new byte [BUFFER_SIZE];
                 while (in.read(buffer) > 0 ) {
                    out.write(buffer);
                } 
            } finally {
                 if ( null != in) {
                    in.close();
                } 
                 if ( null != out) {
                    out.close();
                } 
            } 
        } catch (Exception e) {
            e.printStackTrace();
        } 
		
	}

	public String listAlbum(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("pageshow","albumlist");
		setAllist(albumService.doGetAlbumList());
		return "list";
	}
	
	public String showAlbum(){
		String abid=ServletActionContext.getRequest().getParameter("album_id");
		int id = Integer.parseInt(abid);
		try {
			Album abtmp= albumService.doGetAlbum(id);
			setPlist(abtmp.getPhotos());
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		System.out.println("ok!~");
		return "show";
	}
	
	public String deleteAlbum(){
		String abid=ServletActionContext.getRequest().getParameter("abid");
		int id = Integer.parseInt(abid);
		try {
			albumService.deleteAlbum(id , Album.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "delete";
	}
	
	public void getpicAlbum(){
		
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}

}
