package wsvintsitsky.instinctools.sqlnosql.dataaccess;

import java.util.List;

import wsvintsitsky.instinctools.sqlnosql.datamodel.Book;

public interface BookDao extends AbstractDao<Book, Long> {

	List<Book> findAll() throws Exception;
	
	List<Book> findFreeBooks() throws Exception;
}
