package wsvintsitsky.instinctools.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InstinctoolsApplicationContext extends AnnotationConfigApplicationContext {

	public InstinctoolsApplicationContext() {
		super(InstinctoolsContextConfiguration.class);
	}
}
