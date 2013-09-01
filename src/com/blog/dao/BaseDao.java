package com.blog.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDao extends HibernateDaoSupport {
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getObjects(String queryString){
		
		return this.getHibernateTemplate().find(queryString);
	}
	
	public <T> List<T> getAllObjects(Class<T> clazz){
		return this.getHibernateTemplate().loadAll(clazz);
	}
	
	public <T> Serializable addObject(T clazz){
		return this.getHibernateTemplate().save(clazz);
	}
	
	public <T> void updateObject(T clazz){
		this.getHibernateTemplate().update(clazz);
	}
	
	public <T> void deleteObject(T clazz){
		this.getHibernateTemplate().delete(clazz);
	}
	
	public <T> T getObject(Class<T> clazz,Serializable id){
		return this.getHibernateTemplate().get(clazz, id);
	}
	
	public List findByPage(final String hql, final int offset, final int pageSize){  
        List list = getHibernateTemplate().executeFind(new HibernateCallback() {  
            public Object doInHibernate(Session session) throws HibernateException,  
                    SQLException {  
                List result = session.createQuery(hql).setFirstResult(offset)  
                                .setMaxResults(pageSize)  
                                .list();  
                return result;  
            }  
        });  
        return list;  
    }

	public int getAllRowCount(String hql) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find(hql).size();
	}  
}
