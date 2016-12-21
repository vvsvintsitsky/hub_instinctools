package wsvintsitsky.instinctools.boot;

import java.io.IOException;
import wsvintsitsky.instinctools.classloading.ClassManager;
import wsvintsitsky.instinctools.classloading.JarTypeEnum;
import wsvintsitsky.instinctools.io.impl.JarNameInputHandler;
import wsvintsitsky.instinctools.pathgenerator.impl.ConsumerPathGenerator;
import wsvintsitsky.instinctools.pathgenerator.impl.ProducerPathGenerator;
import wsvintsitsky.instinctools.pathgenerator.impl.SharedResourcePathGenerator;

public class ClassLoadingBoot {

	public static void main(String[] args) throws IOException {
		int consumerCount = Integer.parseInt(args[0]);
		int producerCount = Integer.parseInt(args[1]);
		JarNameInputHandler inputHandler = new JarNameInputHandler();
		
		Class<?> sharedResourceClass = ClassManager.getInstace().getClassFromJar(JarTypeEnum.SHARED_RESOURCE,
				inputHandler.getJarName(new SharedResourcePathGenerator()));
		Class<?> consumerClass = ClassManager.getInstace().getClassFromJar(JarTypeEnum.CONSUMER,
				inputHandler.getJarName(new ConsumerPathGenerator()));
		Class<?> producerClass = ClassManager.getInstace().getClassFromJar(JarTypeEnum.PRODUCER,
				inputHandler.getJarName(new ProducerPathGenerator()));
		
		ScenarioPooler scenarioPooler = new ScenarioPooler();
		scenarioPooler.poolScenario(sharedResourceClass, consumerClass, producerClass, consumerCount, producerCount);
	}

}
