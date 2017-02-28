package wsvintsitsky.instinctools.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import wsvintsitsky.instinctools.configuration.InstinctoolsContextConfiguration;
import wsvintsitsky.instinctools.configuration.PropertiesConfig;
import wsvintsitsky.instinctools.service.impl.RegistrationServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { InstinctoolsContextConfiguration.class, PropertiesConfig.class })
public class RegistrationServiceTest {

	@Autowired
	@Qualifier("annotationRegistrationService")
	private RegistrationService registrationService;

	@Test
	public void chechRegistrationService() {
		Assert.notNull(registrationService);
	}

	@Test
	public void test() {
		RegistrationServiceImpl registrationServiceImpl = (RegistrationServiceImpl) registrationService;
		System.out.println(registrationServiceImpl.hostEmail);
	}
}
