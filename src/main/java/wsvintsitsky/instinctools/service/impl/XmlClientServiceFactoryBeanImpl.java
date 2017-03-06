package wsvintsitsky.instinctools.service.impl;

import wsvintsitsky.instinctools.dataaccess.ClientDao;
import wsvintsitsky.instinctools.service.ClientService;
import wsvintsitsky.instinctools.service.ClientServiceFactoryBean;

public class XmlClientServiceFactoryBeanImpl implements ClientServiceFactoryBean {

	private ClientDao clientDao;

	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public ClientService getObject() throws Exception {
		XmlClientServiceImpl xmlClientServiceImpl = new XmlClientServiceImpl();
		xmlClientServiceImpl.setClientDao(clientDao);
		return xmlClientServiceImpl;
	}

	@Override
	public Class<XmlClientServiceImpl> getObjectType() {
		return XmlClientServiceImpl.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
