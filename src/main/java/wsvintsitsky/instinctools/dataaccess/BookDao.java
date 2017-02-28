package wsvintsitsky.instinctools.dataaccess;

import java.util.List;

import wsvintsitsky.instinctools.datamodel.sqlnosql.Book;

public interface BookDao extends AbstractDao<Book, Long> {

	List<Book> findAll() throws Exception;

	List<Book> findFreeBooks() throws Exception;
}
