package wsvintsitsky.instinctools.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import wsvintsitsky.instinctools.service.RegistrationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:service-context.xml" })
public class XmlRegistrationServiceTest {

	@Autowired
	private RegistrationService registrationService;

	@Test
	public void test() {
		Assert.notNull(registrationService);
	}

	@Test
	public void testUsername() {
		Assert.isTrue(((XmlRegistrationServiceImpl) registrationService).getUsername().equals("Awesome"));
	}
}
