package wsvintsitsky.instinctools.jpa.dataaccess.impl;

import wsvintsitsky.instinctools.jpa.dataaccess.ClientDao;
import wsvintsitsky.instinctools.jpa.datamodel.Person;

public class ClientDaoImpl extends AbstractDaoImpl<Person, Long> implements ClientDao {

	public ClientDaoImpl() {
		super();
		setEntityClass(Person.class);
	}
}
