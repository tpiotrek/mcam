package pl.mcam.web.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Tokarz Piotr
 *
 */
public interface IDao<T extends Object> {
	
	void create(T obj);
	T get(Serializable id);
	T load(Serializable id);
	List<T> getAll();
	void update(T obj);
	void delete(T obj);
	void deleteBydId(Serializable id);
	int deleteAll();
	long count();
	boolean exists(Serializable id);
}
