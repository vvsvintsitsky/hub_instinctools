package wsvintsitsky.instinctools.file.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import wsvintsitsky.instinctools.file.IFileGetter;

public class FileGetter implements IFileGetter {

	public List<File> getFilesFromFolder(final File folder, boolean isFolder) {
		List<File> files = new ArrayList<File>();
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory() == isFolder) {
				files.add(fileEntry);
			}
		}
		return files;
	}
	
	public List<File> getFilesFromFolder(String path, boolean isFolder) {
		List<File> files = new ArrayList<File>();
		File folder = new File(path);
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory() == isFolder) {
				files.add(fileEntry);
			}
		}
		return files;
	}

}
