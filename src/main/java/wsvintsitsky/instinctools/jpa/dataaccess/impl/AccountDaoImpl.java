package wsvintsitsky.instinctools.jpa.dataaccess.impl;

import wsvintsitsky.instinctools.jpa.dataaccess.AccountDao;
import wsvintsitsky.instinctools.jpa.datamodel.Account;

public class AccountDaoImpl extends AbstractDaoImpl<Account, Long> implements AccountDao {
	
	public AccountDaoImpl() {
		super();
		setEntityClass(Account.class);
	}
}
