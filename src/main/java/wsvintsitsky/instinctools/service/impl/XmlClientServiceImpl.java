package wsvintsitsky.instinctools.service.impl;

import wsvintsitsky.instinctools.datamodel.sqlnosql.Client;
import wsvintsitsky.instinctools.service.BookService;
import wsvintsitsky.instinctools.service.ClientService;

public class XmlClientServiceImpl implements ClientService {

	private BookService bookService;
	
	@Override
	public Client findClient(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client saveOrUpdate(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

}
