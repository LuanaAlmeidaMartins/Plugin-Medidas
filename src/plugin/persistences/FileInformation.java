package plugin.persistences;

import java.util.ArrayList;

public class FileInformation {
	
	private String featureName;
	private ArrayList<String> javaFiles;
	private ArrayList<String> jakFiles;
	
	public FileInformation(String featureName, ArrayList<String> javaFiles, ArrayList<String>jakfiles) {
		this.featureName = featureName;
		this.jakFiles = jakfiles;
		this.javaFiles = javaFiles;
	}

	public String getFeatureName() {
		return featureName;
	}

	public ArrayList<String> getJavaFiles() {
		return javaFiles;
	}

	public ArrayList<String> getJakFiles() {
		return jakFiles;
	}
}
