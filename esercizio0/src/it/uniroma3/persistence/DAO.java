package it.uniroma3.persistence;

import java.util.List;

public interface DAO<T>{
	
	public void save(T entity);
	public T update(T entity);
	public T findByPrimaryKey(Long id);
	public List<T> findByParameter(String parameter, String column);
	public List<T> findByParameter(String parameter1,String column1,String parameter2, String column2);
	public T remove(T entity);
}
