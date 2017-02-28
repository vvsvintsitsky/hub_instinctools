package wsvintsitsky.instinctools.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import wsvintsitsky.instinctools.configuration.InstinctoolsContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = InstinctoolsContextConfiguration.class)
public class ClientServiceTest {

	@Autowired
	private ClientService clientService;

	@Test
	public void checkClientService() {
		Assert.notNull(clientService);
	}
}
