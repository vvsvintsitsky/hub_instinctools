package wsvintsitsky.instinctools.service.impl;

import wsvintsitsky.instinctools.dataaccess.spring_data.ClientRepository;
import wsvintsitsky.instinctools.service.ClientService;
import wsvintsitsky.instinctools.service.ClientServiceFactoryBean;

public class XmlClientServiceFactoryBeanImpl implements ClientServiceFactoryBean {

	private ClientRepository clientDao;

	public void setClientDao(ClientRepository clientDao) {
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
