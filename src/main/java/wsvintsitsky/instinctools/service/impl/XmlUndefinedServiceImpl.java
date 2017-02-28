package wsvintsitsky.instinctools.service.impl;

import wsvintsitsky.instinctools.service.UndefinedService;
import wsvintsitsky.instinctools.service.locator.RegistrationServiceFactory;

public class XmlUndefinedServiceImpl implements UndefinedService {

	private RegistrationServiceFactory registrationServiceFactory;

	public RegistrationServiceFactory getRegistrationServiceFactory() {
		return registrationServiceFactory;
	}

	public void setRegistrationServiceFactory(RegistrationServiceFactory registrationServiceFactory) {
		this.registrationServiceFactory = registrationServiceFactory;
	}
}
