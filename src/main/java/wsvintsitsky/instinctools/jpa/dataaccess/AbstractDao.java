package wsvintsitsky.instinctools.jpa.dataaccess;

public interface AbstractDao<T, ID> {

    T insert(final T entity);

    T update(T entity);

    void delete(ID id);
}
