package com.blog.service;

import java.util.LinkedList;
import java.util.List;

import com.blog.dao.BaseDao;
import com.blog.orm.Passage;
import com.blog.plugin.PageBean;

public class PassageManager<T> {
	private BaseDao dao;
	//获取文章
	public Passage doGetPassage(int id) throws Exception{
		if(id <= 0 ) return null;
		String queryString = "SELECT p FROM Passage p WHERE p.id = "+id ;
		List<Passage> passage = dao.getObjects(queryString);
		return passage.get(0);
	}
	//修改文章
	public void doEditPassage(T passageinfo) throws Exception{
		dao.updateObject(passageinfo);
	}
	//添加文章
	public void doAddPassage(T passageinfo) throws Exception{
		dao.addObject(passageinfo);
	}
	//删除文章
	public void deletePassage(int id,Class<T> clazz) throws Exception{
		T p = dao.getObject(clazz, id);
		dao.deleteObject(p);
	}
	//获取文章列表
	public List<Passage> doGetPassageList(){
		return dao.getAllObjects(Passage.class);
	}
	
	public BaseDao getDao() {
		return dao;
	}

	public void setDao(BaseDao dao) {
		this.dao = dao;
	}
	

	public PageBean getPassageByPage(final int page, final int pageSize) {
		final String hql = "from Passage";        //查询语句
		int allRow = dao.getAllRowCount(hql);    //总记录数
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //总页数
        final int offset = PageBean.countOffset(pageSize, page);    //当前页开始记录
        final int length = pageSize;    //每页记录数
		final int currentPage = PageBean.countCurrentPage(page);
		List<Passage> temp = dao.findByPage(hql, offset, length);
		
		PageBean pageBean = new PageBean();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage(currentPage);
        pageBean.setAllRow(allRow);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(temp);
        pageBean.init();
        return pageBean;
	}
}
