package wsvintsitsky.instinctools.service.locator;

import wsvintsitsky.instinctools.service.RegistrationService;

public interface RegistrationServiceFactory {

	RegistrationService getService();
	
	RegistrationService getService(String id);
}
