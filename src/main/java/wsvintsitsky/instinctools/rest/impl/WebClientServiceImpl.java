package wsvintsitsky.instinctools.rest.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import wsvintsitsky.instinctools.datamodel.sqlnosql.Client;
import wsvintsitsky.instinctools.rest.WebClientService;
import wsvintsitsky.instinctools.service.ClientService;

public class WebClientServiceImpl implements WebClientService {

	private ClientService clientService;

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	@Override
	@GET
	@Path("/client/{id}")
	@Produces({ "application/xml", "application/json" })
	public Client findClient(@PathParam("id") Long id) {
		if (id == null) {
			throw new RuntimeException("null id");
		}
		return clientService.findClient(id);
	}

	@Override
	@POST
	@Path("/client/")
	@Produces({ "application/xml", "application/json" })
	@Consumes({ "application/xml", "application/json" })
	public Client saveClient(Client client) {
		return clientService.saveOrUpdate(client);
	}

	@Override
	@PUT
	@Path("/client/")
	@Produces({ "application/xml", "application/json" })
	@Consumes({ "application/xml", "application/json" })
	public Client updateClient(Client client) {
		return clientService.saveOrUpdate(client);
	}

	@Override
	@DELETE
	@Path("/client/{id}")
	public void deleteClient(@PathParam("id") Long id) {
		clientService.deleteClient(id);
	}

}
