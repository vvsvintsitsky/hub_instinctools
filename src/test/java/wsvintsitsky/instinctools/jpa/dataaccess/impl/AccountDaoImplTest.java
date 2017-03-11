package wsvintsitsky.instinctools.jpa.dataaccess.impl;

import java.util.Date;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import wsvintsitsky.instinctools.jpa.datamodel.Account;
import wsvintsitsky.instinctools.jpa.datamodel.Person;

public class AccountDaoImplTest extends TestCase {

	public static Test suite() {
		return new TestSuite(AccountDaoImplTest.class);
	}

	public void testEntityManagerCreation() {
		AccountDaoImpl clientDaoImpl = new AccountDaoImpl();
		assertNotNull(clientDaoImpl.getEntityManager());
	}

	public void testInsert() {
		AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
		ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
		Account account = new Account();
		Person client = new Person();
		clientDaoImpl.insert(client);
		account.setPerson(client);
		account.setName(new String("" + new Date().getTime()));
		account = accountDaoImpl.insert(account);
		assertNotNull(account);
		assertNotNull(account.getId());
	}

	public void testFind() {
		AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
		ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
		Account account = new Account();
		Person client = new Person();
		clientDaoImpl.insert(client);
		account.setPerson(client);
		account.setName(new String("" + new Date().getTime()));
		account = accountDaoImpl.insert(account);
		assertNotNull(account.getId());
		Account result = accountDaoImpl.find(account.getId());
		assertNotNull(result);
		account.setPerson(null);
		result.setPerson(null);
		assertEquals(account, result);
	}

	public void testUpdate() {
		AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
		ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
		Account account = new Account();
		Person client = new Person();
		clientDaoImpl.insert(client);
		account.setPerson(client);
		account.setName(new String("" + new Date().getTime()));
		account = accountDaoImpl.insert(account);
		account.setName(new String("" + new Date().getTime()));
		Account result = accountDaoImpl.update(account);
		assertNotNull(result);
		account.setPerson(null);
		result.setPerson(null);
		assertEquals(account, result);
	}

	public void testDelete() {
		AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
		ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
		Account account = new Account();
		Person client = new Person();
		clientDaoImpl.insert(client);
		account.setPerson(client);
		account.setName(new String("" + new Date().getTime()));
		Long id = accountDaoImpl.insert(account).getId();
		accountDaoImpl.delete(id);
		assertNull(accountDaoImpl.find(id));
	}
}
