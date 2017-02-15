package wsvintsitsky.instinctools.sqlnosql.datamodel.util;

import wsvintsitsky.instinctools.sqlnosql.datamodel.Client;

public class ClientFactory implements AbstractModelFactory {

	@Override
	public Client createEntity() {
		return new Client();
	}

}
