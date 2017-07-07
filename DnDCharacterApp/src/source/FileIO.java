package source;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * This is to save and load character files. It also verifies all the locations need are created.
 * 
 * The character files are xml files saved as .char. There might be a settings file in a later version.
 * 
 * @author Devon Adair
 *
 */
public class FileIO {
	
	private String decodedPath;
	private	JFrame frame;
	private ApplicationGUI applicationGUI;
	
	public FileIO(JFrame frame2, ApplicationGUI applicationGUI){
		// Get the Current Location of File
        String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        
        try {
			decodedPath = URLDecoder.decode(path, "UTF-8");
			System.out.println(decodedPath);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        this.frame = frame2;
        this.applicationGUI = applicationGUI;
	}
	
	/**
	 * Checks to make sure that
	 * TODO finish checking files
	 */
	public void check() {
		File characterFile = new File(decodedPath + "/Character");
		if(!characterFile.exists()){
			characterFile.mkdirs();
		}

	}
	
	public void createCharacter(){
		
	}
	
	public boolean saveCharacter(String location, Character player){

		  try {
			File file = getFile(true);
//			File file = new File("C:/Users/dachi/git/DnDCharacterApp/DnDCharacterApp/Character/" + location + ".char");
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Character.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(player, file);
			jaxbMarshaller.marshal(player, System.out);

		      } catch (JAXBException e) { //TODO fix eating exception
		    	  e.printStackTrace();
		      }
	return true;
	}
	
	public boolean loadCharacter(){
		 try {
			 	
			 	File file = getFile(false);
//				File file = new File("C:/Users/dachi/git/DnDCharacterApp/DnDCharacterApp/Character/" + "test" + ".char");
				JAXBContext jaxbContext = JAXBContext.newInstance(Character.class);
		
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				Character playerLoaded = (Character) jaxbUnmarshaller.unmarshal(file);
				System.out.println(playerLoaded.getName());
				
				this.frame.dispose();
//				this.frame.initialize();
				this.applicationGUI.initialize(playerLoaded);
		
			  } catch (JAXBException e) {
				e.printStackTrace();
			  }

		return true;
	}
	
	public File getFile(boolean save){
		JFileChooser chooser = new JFileChooser();
		//TODO change back to decoded path
		chooser.setCurrentDirectory(new File("C:/Users/dachi/git/DnDCharacterApp/DnDCharacterApp/Character/" ));
		//TODO figure out how to filter only characters
//		FileNameExtensionFilter filter = new FileNameExtensionFilter(
//		        "char"); // filter only character files
//		chooser.setFileFilter(filter);
		
		int returnVal = chooser.showOpenDialog(this.frame);
		//TODO fix this so it saves with .char
		if(!chooser.getTypeDescription(chooser.getSelectedFile()).equals(".char") && save){
			chooser.getSelectedFile().renameTo(new File(chooser.getSelectedFile().getAbsolutePath()
												+ chooser.getName() + ".char"));
			System.out.println(chooser.getSelectedFile().getAbsolutePath()
												+ chooser.getName() + ".char");
		}
		if(returnVal == JFileChooser.APPROVE_OPTION) {
		       System.out.println("You chose to open this file: " +
		            chooser.getSelectedFile().getName());
		    }
		return chooser.getSelectedFile();
	}
}
