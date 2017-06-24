/**
 * 
 */
package edu.csulb.library.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Manav
 *
 */
public interface BookDao<T, Id extends Serializable> {

	public void persist(T entity);

	public void update(T entity);

	public T findById(Id id);

	public void deleteBook(T entity);

	public List<T> findAllBooks();

	public void deleteAllBooks();
}
