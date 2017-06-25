package source;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This is to save and load character files. It also verifies all the locations need are created.
 * 
 * The character files are xml files saved as .char. There might be a settings file in a later version.
 * 
 * @author Devon Adair
 *
 */
public class FileIO {
	
	/**
	 * Checks to make sure that
	 */
	public void check() {
		Path path = null; 
		try {
			path = Paths.get(ApplicationGUI.class.getProtectionDomain().getCodeSource().getLocation().toURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File characterFile = new File(path + "Character");
		if(!characterFile.exists()){
			characterFile.mkdirs();
		}
		
	}
	
	public void createCharacter(){
		
	}
	
	public void saveCharacter(){
		
	}
	
	public void loadCharacter(){
		
	}
	
}
