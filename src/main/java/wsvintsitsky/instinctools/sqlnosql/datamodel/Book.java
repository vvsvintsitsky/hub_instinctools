package wsvintsitsky.instinctools.sqlnosql.datamodel;

public class Book extends AbstractModel {

	private static final long serialVersionUID = 1L;

	private String name;
	
	private Client client;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
