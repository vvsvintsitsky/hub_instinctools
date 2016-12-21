package wsvintsitsky.instinctools.io.impl;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import wsvintsitsky.instinctools.file.impl.FileGetter;
import wsvintsitsky.instinctools.io.IInputHandler;
import wsvintsitsky.instinctools.pathgenerator.IPathGenerator;

public class JarNameInputHandler implements IInputHandler {

	private static final Logger LOGGER = LogManager.getLogger(JarNameInputHandler.class);
	
	@Override
	public String getJarName(IPathGenerator pathGenerator) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		FileGetter fileGetter = new FileGetter();
		List<File> jars = fileGetter.getFilesFromFolder(pathGenerator.generatePath(), false);
		FilePrinter.getInstance().printFiles(jars);
		int choise = -1;

		do {
			try {
				choise = Integer.parseInt(scanner.next());
			} catch (NumberFormatException numberFormatException) {
				LOGGER.error("invalid number format");
			}
		} while (choise < 0 || choise >= jars.size());

		return jars.get(choise).getName();
	}

}
