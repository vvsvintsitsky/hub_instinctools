package wsvintsitsky.instinctools.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import wsvintsitsky.instinctools.service.UndefinedService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:service-context.xml" })
public class XmlUndefinedServiceTest {

	@Autowired
	private UndefinedService undefinedService;

	@Test
	public void test() {
		XmlUndefinedServiceImpl xmlUndefinedServiceImpl = (XmlUndefinedServiceImpl) undefinedService;
		Assert.notNull(xmlUndefinedServiceImpl.getRegistrationServiceFactory());
	}

	@Test
	public void testFB() {
		XmlUndefinedServiceImpl xmlUndefinedServiceImpl = (XmlUndefinedServiceImpl) undefinedService;
		Assert.notNull(xmlUndefinedServiceImpl.getRegistrationServiceFactory().getService());
	}
}
