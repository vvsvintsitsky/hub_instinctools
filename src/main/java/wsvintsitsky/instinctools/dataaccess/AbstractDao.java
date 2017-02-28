package wsvintsitsky.instinctools.dataaccess;

public interface AbstractDao<T, ID> {

	T find(ID id) throws Exception;

	T insert(final T entity) throws Exception;

	T update(T entity) throws Exception;

	void delete(ID id) throws Exception;
}
