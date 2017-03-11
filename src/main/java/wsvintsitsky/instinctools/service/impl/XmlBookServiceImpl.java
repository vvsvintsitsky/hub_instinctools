package wsvintsitsky.instinctools.service.impl;

import java.util.List;

import wsvintsitsky.instinctools.dataaccess.spring_data.BookRepository;
import wsvintsitsky.instinctools.datamodel.sqlnosql.Book;
import wsvintsitsky.instinctools.service.BookService;

public class XmlBookServiceImpl implements BookService {

	private BookRepository bookDao;
	
	@Override
	public Book findBook(Long id) {
		Book book = null;
		try {
			book = bookDao.findOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public Book saveOrUpdate(Book book) {
		return bookDao.save(book);
	}
	
	@Override
	public void deleteBook(Long id) {
		try {
			bookDao.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = null;
		try {
			books = bookDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public List<Book> getBooksByClientId(Long clientId) {
		List<Book> books = null;
		try {
			books = bookDao.findByClient_Id(clientId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	public void setBookDao(BookRepository bookDao) {
		this.bookDao = bookDao;
	}

	public void init() {
		System.out.println(this.getClass().getSimpleName() + " initialized");
	}

	public void destroy() {
		System.out.println(this.getClass().getSimpleName() + " destroyed");
	}

	public static BookService getInstance(BookRepository bookDao) {
		XmlBookServiceImpl xmlBookServiceImpl = new XmlBookServiceImpl();
		xmlBookServiceImpl.setBookDao(bookDao);
		return xmlBookServiceImpl;
	}
}
