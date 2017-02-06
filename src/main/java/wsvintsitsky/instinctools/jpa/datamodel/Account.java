package wsvintsitsky.instinctools.jpa.datamodel;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

public class Account extends AbstractModel {

	@ManyToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
	private Client client;
	
	@Column
	private String name;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
