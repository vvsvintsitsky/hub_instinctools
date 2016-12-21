package wsvintsitsky.instinctools.io.impl;

import java.io.File;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import wsvintsitsky.instinctools.io.IFilePrinter;

public class FilePrinter implements IFilePrinter {

	private static final FilePrinter INSTANCE = new FilePrinter();
	
	private static final Logger LOGGER = LogManager.getLogger(FilePrinter.class);
	
	public static FilePrinter getInstance() {
		return INSTANCE;
	}
	
	public void printFiles(List<File> files) {
		for (File fileEntry : files) {
			LOGGER.info(fileEntry.getName());
		}
	}
}
