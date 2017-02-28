package wsvintsitsky.instinctools.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import wsvintsitsky.instinctools.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:service-context.xml" })
public class XmlBookServiceTest {

	@Autowired
	private BookService bookService;

	@Test
	public void test() {
		Assert.notNull(bookService);
	}

	@Test
	public void testCl() {
		XmlBookServiceImpl xmlBookServiceImpl = (XmlBookServiceImpl) bookService;
		Assert.notNull(xmlBookServiceImpl.getClientService());
	}
}
