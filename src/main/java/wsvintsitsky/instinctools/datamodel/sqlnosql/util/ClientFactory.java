package wsvintsitsky.instinctools.datamodel.sqlnosql.util;

import wsvintsitsky.instinctools.datamodel.sqlnosql.Client;

public class ClientFactory implements AbstractModelFactory {

	@Override
	public Client createEntity() {
		return new Client();
	}

}
