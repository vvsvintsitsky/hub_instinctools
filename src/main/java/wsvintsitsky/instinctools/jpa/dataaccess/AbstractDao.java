package wsvintsitsky.instinctools.jpa.dataaccess;

public interface AbstractDao<T, ID> {
	
	T find(ID id);
	
    T insert(final T entity);

    T update(T entity);

    void delete(ID id);
}
