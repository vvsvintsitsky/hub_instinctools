package wsvintsitsky.instinctools.service.impl;

import wsvintsitsky.instinctools.service.BookService;
import wsvintsitsky.instinctools.service.ClientService;
import wsvintsitsky.instinctools.service.ClientServiceFactoryBean;

public class XmlClientServiceFactoryBeanImpl implements ClientServiceFactoryBean {

	private BookService bookService;

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public ClientService getObject() throws Exception {
		XmlClientServiceImpl xmlClientServiceImpl = new XmlClientServiceImpl();
		xmlClientServiceImpl.setBookService(bookService);
		return xmlClientServiceImpl;
	}

	@Override
	public Class<XmlClientServiceImpl> getObjectType() {
		return XmlClientServiceImpl.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
