package wsvintsitsky.instinctools.service.impl;

import wsvintsitsky.instinctools.service.UndefinedService;
import wsvintsitsky.instinctools.service.locator.RegistrationServiceFactory;
import wsvintsitsky.instinctools.service.locator.UndefinedServiceFactory;

public class XmlUndefinedServiceFactoryImpl implements UndefinedServiceFactory {

	private RegistrationServiceFactory registrationServiceFactory;

	public XmlUndefinedServiceFactoryImpl(RegistrationServiceFactory registrationServiceFactory) {
		this.registrationServiceFactory = registrationServiceFactory;
	}

	@Override
	public UndefinedService getInstance() {
		XmlUndefinedServiceImpl xmlUndefinedServiceImpl = new XmlUndefinedServiceImpl();
		xmlUndefinedServiceImpl.setRegistrationServiceFactory(registrationServiceFactory);
		return xmlUndefinedServiceImpl;
	}
}
