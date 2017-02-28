package wsvintsitsky.instinctools.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wsvintsitsky.instinctools.datamodel.sqlnosql.Book;
import wsvintsitsky.instinctools.service.BookService;
import wsvintsitsky.instinctools.service.ClientService;

@Service("annotationBookService")
public class BookServiceImpl implements BookService {

	protected ClientService clientService;
	
	@Autowired
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

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
}
