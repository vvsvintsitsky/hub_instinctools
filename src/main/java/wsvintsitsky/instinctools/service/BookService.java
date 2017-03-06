package wsvintsitsky.instinctools.service;

import java.util.List;

import wsvintsitsky.instinctools.datamodel.sqlnosql.Book;

public interface BookService {

	public Book findBook(Long id);

	public Book saveOrUpdate(Book book);
	
	public void deleteBook(Long id);
	
	public List<Book> getAllBooks();
	
	public List<Book> getFreeBooks();
}
