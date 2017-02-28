package wsvintsitsky.instinctools.service.impl;

import wsvintsitsky.instinctools.datamodel.sqlnosql.Book;
import wsvintsitsky.instinctools.service.BookService;
import wsvintsitsky.instinctools.service.ClientService;

public class XmlBookServiceImpl implements BookService {

	private ClientService clientService;
	
	@Override
	public Book findBook(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book saveOrUpdate(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public void init() {
		System.out.println(this.getClass().getSimpleName() + " initialized");
	}
	
	public void destroy() {
		System.out.println(this.getClass().getSimpleName() + " destroyed");
	}
	
	public static BookService getInstance(ClientService clientService) {
		XmlBookServiceImpl xmlBookServiceImpl = new XmlBookServiceImpl();
		xmlBookServiceImpl.setClientService(clientService);
		return xmlBookServiceImpl;
	}
}
