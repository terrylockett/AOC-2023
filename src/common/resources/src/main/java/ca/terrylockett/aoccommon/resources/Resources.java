package ca.terrylockett.aoccommon.resources;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;

public class Resources {
	
	private Resources() {
		//top secret hidden constructor.
	}

	public static Optional<String> getInput(String fileName) {
		var inputStream = ClassLoader.getSystemResourceAsStream(fileName);
		if (null == inputStream) {
			return Optional.empty();
		}
		
		try {
			String fileContents = new String(inputStream.readAllBytes());
			if (fileContents.endsWith("\n")) {
				fileContents = fileContents.substring(0, fileContents.lastIndexOf('\n'));
			}
			return Optional.of(fileContents);
		}
		catch (IOException e) {
			System.out.println(e);
			return Optional.empty()	;
		}
	}
	
	/**
	 * This is an odd way to get files, but I think its cute, so it says. <3
	 * <br/><br/>
	 * Running a main method in intellij vs running it from the run task will have different working dirs which breaks relative paths to the input file.
	 * As a way around this put the input file into the resources dir and then class load the file to find the path.
	 *
	 * @param fileName The name of the file.
	 * @return The absolute path to the file.
	 */
	public static Optional<String> getInputFilePath(String fileName) throws URISyntaxException {
		
		URL resource = ClassLoader.getSystemResource(fileName);
		if (resource == null) {
			return Optional.empty();
		}
		
		System.out.println("aaaaaaaaa: " + resource);
		
		return Optional.of(new File(resource.toURI()).getAbsolutePath());
	}
}
