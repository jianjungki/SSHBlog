package com.blog.action;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.imgscalr.Scalr;

import com.blog.orm.Album;
import com.blog.orm.Photo;
import com.blog.orm.Userinfo;
import com.blog.service.AlbumManager;
import com.blog.service.PhotoService;
import com.blog.service.UserManagerService;

public class PhotoAction {
	private static final int BUFFER_SIZE = 1024*16;
	private UserManagerService<Userinfo> userService;
	private PhotoService<Photo> pservice;
	private AlbumManager<Album> abservice;
	private Photo phinfo;
	private List<File> files;
	private List<String> filesFileName;
	private List<String> filesContentType;
	private String savePath;
	private int albumId;
	private Album abtemp;
	
	public Album getAbtemp() {
		return abtemp;
	}

	public void setAbtemp(Album abtemp) {
		this.abtemp = abtemp;
	}

	private Map<String, Object> dataMap; 
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public List<String> getFilesFileName() {
		return filesFileName;
	}

	public void setFilesFileName(List<String> filesFileName) {
		this.filesFileName = filesFileName;
	}

	public List<String> getFilesContentType() {
		return filesContentType;
	}

	public void setFilesContentType(List<String> filesContentType) {
		this.filesContentType = filesContentType;
	}

	public AlbumManager<Album> getAbservice() {
		return abservice;
	}

	public void setAbservice(AlbumManager<Album> abservice) {
		this.abservice = abservice;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public PhotoService<Photo> getPservice() {
		return pservice;
	}

	public void setPservice(PhotoService<Photo>  pservice) {
		this.pservice = pservice;
	}

	public UserManagerService<Userinfo> getUserService() {
		return userService;
	}
	
	public void setUserService(UserManagerService<Userinfo> userService) {
		this.userService = userService;
	}
	
	public Photo getPhinfo() {
		return phinfo;
	}
	
	public void setPhinfo(Photo phinfo) {
		this.phinfo = phinfo;
	}
	
	public String addPhoto(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("pageshow","photoadd");
		return "add";
	}
	
	public String photoAdd(){
		return "success";
	}
	
	public String showPhoto(){

		return "show";
	}
	
	public String addactionPhoto() throws IOException{
		 HttpServletRequest request = ServletActionContext.getRequest();
		 String dstPath =ServletActionContext.getServletContext().getRealPath("/photoimg");
		 List<Photo> list = new LinkedList<Photo>();
		 System.out.println(request.getParameter("albid"));
		 
		 if(files!=null){  
	            File savedir = new File(dstPath);
	            File thumbdir = new File(dstPath+"/thumb");  
	            if(!savedir.exists()){  
	                savedir.mkdirs();  
	            }  
	            if(!thumbdir.exists()){  
	                savedir.mkdirs();  
	            }  
	            for(int i=0;i<files.size();i++){
	            	String newFilenameBase = UUID.randomUUID().toString();
	            	String originalFileExtension = filesFileName.get(i).substring(filesFileName.get(i).lastIndexOf("."));
	            	String newFilename = newFilenameBase + originalFileExtension;
	                File saveFile = new File(savedir,newFilename); 
	                try {  
	                    FileUtils.copyFile(files.get(i), saveFile);  
	                } catch (IOException e) {  
	                    e.printStackTrace();  
	                }  
	                BufferedImage thumbnail = Scalr.resize(ImageIO.read(saveFile), 50);
	                String thumbnailFilename = newFilenameBase + "-thumbnail.png";
	                File thumbnailFile = new File(thumbdir,thumbnailFilename);
	                ImageIO.write(thumbnail, "png", thumbnailFile);

					 Photo photo = new Photo();
					 photo.setFilename(newFilename);
					 photo.setThumbnailFilename(thumbnailFilename);
					 photo.setNewFilename(newFilename);
					 photo.setContentType(filesContentType.get(i));
					 photo.setSize(files.get(i).length());
					 photo.setAuthor("admin");
					 photo.setPosttime(new Date());
					 int getid = 0;
					 try {
						getid = pservice.doAddPhoto(photo);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					    
					 photo.setUrl("/BlogApp/photo_picurl?picid="+getid);
					 photo.setThumbnail_url("/BlogApp/photo_tumbnail?picid="+getid);
					 photo.setDelete_url("/BlogApp/photo_delete?picid="+getid);
					 photo.setDelete_type("DELETE");
					 list.add(photo);
					 //System.out.println(getid);
					 
					 
					 String abId=request.getParameter("albid");
					 
					 try {
						abtemp = abservice.doGetAlbum(Integer.parseInt(abId));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 Set<Photo> phset = abtemp.getPhotos();
					 phset.add(photo);
					 abtemp.setPhotos(phset);
					 try {
						abservice.doEditAlbum(abtemp);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 
	            }  
	        } 

		 
		 dataMap = new HashMap<String, Object>();
		 dataMap.clear();
		 dataMap.put("files", list);
	     return "addsuccess";
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
	
	/*
	 * 缩略图显示功能
	 */
	public String tumbnailPhoto() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String getid = (String)request.getParameter("picid");
		
		int idnum = Integer.parseInt(getid);
		Photo phtemp = null;
		System.out.println(idnum);
		try {
			phtemp = pservice.doGetPhoto(idnum);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tumburl = phtemp.getThumbnailFilename();
		System.out.println(tumburl);
		
		String dstPath =ServletActionContext.getServletContext().getRealPath("/photoimg");
		
		FileInputStream hFile = new FileInputStream(dstPath+"/thumb/"+tumburl); // 
        System.out.println(dstPath+"/thumb/"+tumburl);
		int i=hFile.available(); //得到文件大小   
        byte data[]=new byte[i];   
        
        hFile.read(data);  //读数据   
        response.setContentType("image/png"); //设置返回的文件类型   
        OutputStream toClient=response.getOutputStream(); //得到向客户端输出二进制数据的对象   
        toClient.write(data);  //输出数据   
        
        toClient.flush();  
        toClient.close();   
        hFile.close();   
        
        return null;  
	}
	
	/*
	 * 图片显示功能
	 */
	public String picurlPhoto() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String getid = (String)request.getParameter("picid");
		
		int idnum = Integer.parseInt(getid);
		Photo phtemp = null;
		System.out.println(idnum);
		try {
			phtemp = pservice.doGetPhoto(idnum);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tumburl = phtemp.getFilename();
		System.out.println(tumburl);
		
		String dstPath =ServletActionContext.getServletContext().getRealPath("/photoimg");
		
		FileInputStream hFile = new FileInputStream(dstPath+"/"+tumburl); // 
        System.out.println(dstPath+"/"+ tumburl);
		int i=hFile.available(); //得到文件大小   
        byte data[]=new byte[i];   
        
        hFile.read(data);  //读数据   
        response.setContentType("image/*"); //设置返回的文件类型   
        OutputStream toClient=response.getOutputStream(); //得到向客户端输出二进制数据的对象   
        toClient.write(data);  //输出数据   
        
        toClient.flush();  
        toClient.close();   
        hFile.close();   
        
        return null;  
	}
	
	public String deletePhoto(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String getid = (String)request.getParameter("picid");
		
		int idnum = Integer.parseInt(getid);
		Photo phtemp = null;
		System.out.println(idnum);
		try {
			phtemp = pservice.doGetPhoto(idnum);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String dstPath =ServletActionContext.getServletContext().getRealPath("/photoimg");
		File orgfile = new File(dstPath+"/"+phtemp.getFilename());
		File tempfile = new File(dstPath+"/thumb/"+phtemp.getThumbnailFilename());
		System.out.println(dstPath+"/"+phtemp.getFilename());
		System.out.println(dstPath+"/thumb/"+phtemp.getThumbnailFilename());
		if(orgfile.exists()&&tempfile.exists()){
			orgfile.delete();
			tempfile.delete();
			System.out.println("删除成功");
		}
		try {
			pservice.deletePhoto(idnum, Photo.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "success";
	}
	
	
}
