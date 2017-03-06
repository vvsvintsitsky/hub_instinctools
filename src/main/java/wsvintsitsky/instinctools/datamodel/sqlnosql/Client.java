package wsvintsitsky.instinctools.datamodel.sqlnosql;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import wsvintsitsky.instinctools.pattern.memento.Memento;

@XmlRootElement(name = "Client")
@XmlAccessorType(XmlAccessType.FIELD)
public class Client extends AbstractModel {

	private static final long serialVersionUID = 1L;

	private String name;

	private String email;

	private String password;

	private List<Book> books;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Memento generateMemento() {
		return new ClientNameChangingMemento(name);
	}

	public void setMemento(Memento clientMemento) {
		if (clientMemento instanceof ClientNameChangingMemento) {
			this.name = ((ClientNameChangingMemento) clientMemento).name;
		}
	}

	private class ClientNameChangingMemento implements Memento {
		private String name;

		public ClientNameChangingMemento(String name) {
			super();
			this.name = name;
		}
	}
}
