package wsvintsitsky.instinctools.service;

import wsvintsitsky.instinctools.datamodel.sqlnosql.Book;

public interface BookService {

	public Book findBook(Long id);

	public Book saveOrUpdate(Book book);
}
