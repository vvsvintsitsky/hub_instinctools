package wsvintsitsky.instinctools.soap.impl;

import java.util.List;

import javax.jws.WebService;

import wsvintsitsky.instinctools.datamodel.sqlnosql.Book;
import wsvintsitsky.instinctools.service.BookService;
import wsvintsitsky.instinctools.soap.WebBookService;

@WebService(endpointInterface = "wsvintsitsky.instinctools.soap.WebBookService")
public class WebBookServiceImpl implements WebBookService {

	private BookService bookService;

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public Book insertBook(Book book) {
		return bookService.saveOrUpdate(book);
	}
	
	@Override
	public Book find(Long id) {
		return bookService.findBook(id);
	}

	@Override
	public Book updateBook(Long id, Book book) {
		return bookService.saveOrUpdate(book);
	}

	@Override
	public void deleteBook(Long id) {
		bookService.deleteBook(id);
	}

	@Override
	public List<Book> findAllBooks() {
		return bookService.getAllBooks();
	}

	@Override
	public List<Book> getBooksByClientId(Long clientId) {
		return bookService.getBooksByClientId(clientId);
	}
}
