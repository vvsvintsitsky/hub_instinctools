package wsvintsitsky.instinctools.sqlnosql.datamodel;

import java.util.List;

import wsvintsitsky.instinctools.pattern.memento.Memento;

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

	public Memento getClientMemento() {
		return new ClientNameChangingMeneto(name);
	}

	public void setClientMemento(Memento clientMemento) {
		if(clientMemento instanceof ClientNameChangingMeneto) {
			this.name = ((ClientNameChangingMeneto) clientMemento).name;
		}
	}
	
	private class ClientNameChangingMeneto implements Memento {
		private String name;

		public ClientNameChangingMeneto(String name) {
			super();
			this.name = name;
		}
	}
}
