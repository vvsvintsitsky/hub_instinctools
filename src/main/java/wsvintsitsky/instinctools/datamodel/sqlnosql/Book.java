package wsvintsitsky.instinctools.datamodel.sqlnosql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Book")
@Entity
public class Book extends AbstractModel {

	private static final long serialVersionUID = 1L;

	@Column
	private String name;

	@ManyToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
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
