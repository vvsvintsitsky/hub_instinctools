package wsvintsitsky.instinctools.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import wsvintsitsky.instinctools.datamodel.sqlnosql.Client;
import wsvintsitsky.instinctools.service.ClientService;
import wsvintsitsky.instinctools.service.RegistrationService;

@Service("annotationRegistrationService")
@Scope("prototype")
public class RegistrationServiceImpl implements RegistrationService {

	@Value("${registration.email}")
	public String hostEmail;
	
	@Autowired
	@Qualifier("annotationClientService")
	private ClientService clientService;
	
	public RegistrationServiceImpl(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@Override
	public void register(Client client) {
		clientService.saveOrUpdate(client);
	}
}
