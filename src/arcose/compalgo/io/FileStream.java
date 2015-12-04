package arcose.compalgo.io;

import java.io.File;

public class FileStream {
	
	private File fileSelection;
	
	private enum Option {
		READ, WRITE
	}
	
	public FileStream(String filePath, Option op) {

	}
	
	public File getFileSelection() {
		return fileSelection;
	}
	
	public void setFileSelection(File fileSelection) {
		this.fileSelection = fileSelection;
	}
}
