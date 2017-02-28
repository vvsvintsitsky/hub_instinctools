package wsvintsitsky.instinctools.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wsvintsitsky.instinctools.datamodel.sqlnosql.Client;
import wsvintsitsky.instinctools.service.BookService;
import wsvintsitsky.instinctools.service.ClientService;

@Service("annotationClientService")
public class ClientServiceImpl implements ClientService {

	protected BookService bookService;

	@Autowired
	public ClientServiceImpl(BookService bookService) {
		this.bookService = bookService;
	}

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
}
