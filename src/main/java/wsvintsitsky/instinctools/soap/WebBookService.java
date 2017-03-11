package wsvintsitsky.instinctools.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import wsvintsitsky.instinctools.datamodel.sqlnosql.Book;

@WebService
public interface WebBookService {
	
	@WebMethod
	Book insertBook(Book book);
	
	@WebMethod
	Book find(Long id);
	
	@WebMethod
	Book updateBook(Long id, Book book);
	
	@WebMethod
	void deleteBook(Long id);
	
	@WebMethod
	List<Book> findAllBooks();
	
	@WebMethod
	List<Book> getBooksByClientId(Long clientId);
}
