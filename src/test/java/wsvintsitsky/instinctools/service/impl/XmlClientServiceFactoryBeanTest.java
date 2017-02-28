package wsvintsitsky.instinctools.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import wsvintsitsky.instinctools.service.ClientServiceFactoryBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:service-context.xml" })
public class XmlClientServiceFactoryBeanTest {

	@Autowired
	private ClientServiceFactoryBean clientServiceFactoryBean;

	@Test
	public void test() {
		Assert.notNull(clientServiceFactoryBean);
	}

	@Test
	public void testGetObject() throws Exception {
		XmlClientServiceFactoryBeanImpl xmlRegistrationServiceFactoryBeanImpl = (XmlClientServiceFactoryBeanImpl) clientServiceFactoryBean;
		Assert.notNull(xmlRegistrationServiceFactoryBeanImpl.getObject());
	}
}
