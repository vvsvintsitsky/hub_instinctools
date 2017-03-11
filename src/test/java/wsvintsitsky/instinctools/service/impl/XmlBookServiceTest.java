package wsvintsitsky.instinctools.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import wsvintsitsky.instinctools.dataaccess.spring_data.BookRepository;
import wsvintsitsky.instinctools.dataaccess.spring_data.ClientRepository;
import wsvintsitsky.instinctools.datamodel.sqlnosql.Book;
import wsvintsitsky.instinctools.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:service-context-test.xml" })
public class XmlBookServiceTest {

	@Autowired
	private BookService bookService;

	@Autowired
	private ClientRepository clientDao;
	
	@Autowired
	private BookRepository bookDao;
	
	@Before
	public void wipeDB() throws Exception {
		bookDao.deleteAll();
		clientDao.deleteAll();
	}
	
	@Test
	public void test() {
		Assert.notNull(bookService);
		Book book = new Book();
		book.setName("name");
		bookService.saveOrUpdate(book);
		System.out.println(book.getId());
	}
}
