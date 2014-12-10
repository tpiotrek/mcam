package pl.mcam.web.dao.hbn;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.mcam.web.dao.IDao;

/**
 * 
 * @author Tokarz Piotr
 *
 */
@Repository
public abstract class AbstractDaoImpl<T extends Object> implements IDao<T> {
	
	@Override
	public void create(T obj) {
		//TODO dodac kod ustawiajacy date utworzenia obiektu i kto go ustawil
		getSession().save(obj);
	}
	
	@Override
	public void update(T obj) {
		//TODO dodac kod ustawiaj¹cy date zmainu obiektu i kto go zmienil
		getSession().update(obj);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public T load(Serializable id) {
		return (T)getSession().load(getDomainClass(), id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public T get(Serializable id) {
		return (T)getSession().get(getDomainClass(), id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return getSession()
				.createQuery("FROM "+getDomainClassName())
				.list();
	}
	
	@Override
	public void delete(T obj) {
		getSession().delete(obj);
	}
	
	@Override
	public int deleteAll() {
		return getSession()
				.createQuery("DELETE "+getDomainClassName())
				.executeUpdate();
	}
	
	@Override
	public void deleteBydId(Serializable id) {
		this.delete(this.load(id));
	}
	
	@Override
	public boolean exists(Serializable id) {
		return this.get(id) != null;
	}
	
	@Override
	public long count() {
		return (Long)getSession()
				.createQuery("SELECT COUNT(*) FROM "+getDomainClassName())
				.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	protected Class<T> getDomainClass() {
		if (domainClass == null) {
			ParameterizedType type = (ParameterizedType)getClass().getGenericSuperclass();
			this.domainClass = (Class<T>)type.getActualTypeArguments()[0];
		}
		return domainClass;
	}
	
	protected String getDomainClassName() {
		return getDomainClass().getName();
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Autowired(required=true)
	private SessionFactory sessionFactory;
	
	private Class<T> domainClass;
}
