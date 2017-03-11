package wsvintsitsky.instinctools.jpa.dataaccess.impl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import wsvintsitsky.instinctools.jpa.datamodel.Person;

public class ClientDaoImplTest extends TestCase {

	public static Test suite() {
		return new TestSuite(ClientDaoImplTest.class);
	}

	public void testEntityManagerCreation() {
		ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
		assertNotNull(clientDaoImpl.getEntityManager());
	}

	public void testInsert() {
		ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
		Person client = new Person();
		client = clientDaoImpl.insert(client);
		assertNotNull(client);
		assertNotNull(client.getId());
	}

	public void testFind() {
		ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
		Person client = new Person();
		client = clientDaoImpl.insert(client);
		assertNotNull(client.getId());
		Person result = clientDaoImpl.find(client.getId());
		result.setAccounts(null);
		assertNotNull(result);
		assertEquals(client, result);
	}

	public void testUpdate() {
		ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
		Person client = new Person();
		client = clientDaoImpl.insert(client);
		Person result = clientDaoImpl.update(client);
		assertNotNull(result);
		assertEquals(client, result);
		client = clientDaoImpl.find(result.getId());
		client.setAccounts(null);
		assertEquals(client, result);
	}

	public void testDelete() {
		ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
		Long id = clientDaoImpl.insert(new Person()).getId();
		clientDaoImpl.delete(id);
		assertNull(clientDaoImpl.find(id));
	}
}
