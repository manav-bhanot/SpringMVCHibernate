/**
 * 
 */
package edu.csulb.library.dao;

import java.util.List;

/**
 * @author Manav
 *
 */
public interface BookDao<T> {

	public void persist(T entity);

	public void update(T entity);

	public T findById(long id);

	public void deleteBook(T entity);

	public List<T> findAllBooks();

	public void deleteAllBooks();
}
