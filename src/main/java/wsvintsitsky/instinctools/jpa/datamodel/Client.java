package wsvintsitsky.instinctools.jpa.datamodel;

import java.util.List;

import javax.persistence.OneToMany;

public class Client extends AbstractModel {

	@OneToMany(mappedBy = "client")
	private List<Account> accounts;

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
