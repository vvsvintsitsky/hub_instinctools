package wsvintsitsky.instinctools.service.impl;

import wsvintsitsky.instinctools.datamodel.sqlnosql.Client;
import wsvintsitsky.instinctools.service.ClientService;
import wsvintsitsky.instinctools.service.RegistrationService;

public class XmlRegistrationServiceImpl implements RegistrationService {

	private String username;

	private ClientService clientService;

	public XmlRegistrationServiceImpl(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@Override
	public void register(Client client) {
		clientService.saveOrUpdate(client);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
