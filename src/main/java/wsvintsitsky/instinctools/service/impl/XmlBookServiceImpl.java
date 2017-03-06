package wsvintsitsky.instinctools.service.impl;

import java.util.List;

import wsvintsitsky.instinctools.dataaccess.BookDao;
import wsvintsitsky.instinctools.datamodel.sqlnosql.Book;
import wsvintsitsky.instinctools.service.BookService;

public class XmlBookServiceImpl implements BookService {

	private BookDao bookDao;

	@Override
	public Book findBook(Long id) {
		Book book = null;
		try {
			book = bookDao.find(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public Book saveOrUpdate(Book book) {
		try {
			if (book.getId() == null) {
				book = bookDao.insert(book);
			} else {
				book = bookDao.update(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
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
	public List<Book> getFreeBooks() {
		List<Book> books = null;
		try {
			books = bookDao.findFreeBooks();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public void init() {
		System.out.println(this.getClass().getSimpleName() + " initialized");
	}

	public void destroy() {
		System.out.println(this.getClass().getSimpleName() + " destroyed");
	}

	public static BookService getInstance(BookDao bookDao) {
		XmlBookServiceImpl xmlBookServiceImpl = new XmlBookServiceImpl();
		xmlBookServiceImpl.setBookDao(bookDao);
		return xmlBookServiceImpl;
	}
}
