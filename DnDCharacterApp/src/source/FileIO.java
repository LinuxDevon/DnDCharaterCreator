package source;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	private File saveFile;
	
	public FileIO(){
		
	}
	
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
	
	public boolean saveCharacter(String location, Character player, SpellWindow spells){
//
//		  try {
//			saveFile = getFile(true);
//			
////			File file = new File("C:/Users/dachi/git/DnDCharacterApp/DnDCharacterApp/Character/" + location + ".char");
//			
////			Class[] list = new Class[]{Character.class, SpellWindow.class};
//			JAXBContext jaxbContext = JAXBContext.newInstance(Character.class);
//			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//			// output pretty printed
//			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//			
//			jaxbMarshaller.marshal(player, saveFile);
////			jaxbMarshaller.marshal(spells, saveFile);
////			jaxbMarshaller.marshal(spells, System.out);
////			jaxbMarshaller.marshal(player, System.out);
//
//		      } catch (JAXBException e) { //TODO fix eating exception
//		    	  e.printStackTrace();
//		      }
		  
//		  try {
//		      FileOutputStream fileOut =
//		      new FileOutputStream("C:/Users/dachi/git/DnDCharacterApp/DnDCharacterApp/src/source/test.ser");
//		      ObjectOutputStream out = new ObjectOutputStream(fileOut);
//		      out.writeObject(this.frame);
//		      out.close();
//		      fileOut.close();
//		      System.out.printf("Serialized data is saved in ");
//		   }catch(Exception i) {
//			   i.printStackTrace();  
//		   }
		  
	      try {
	          FileOutputStream fileOut =
	          new FileOutputStream("employee.ser");
	          ObjectOutputStream out = new ObjectOutputStream(fileOut);
	          out.writeObject(this.frame);
	          out.close();
	          fileOut.close();
	          System.out.printf("Serialized data is saved in /tmp/employee.ser");
	       }catch(IOException i) {
	          i.printStackTrace();
	       }
	      
	return true;
	}
	
	public boolean loadCharacter(){

//		    try(
//		    	      InputStream file = new FileInputStream("quarks.ser");
//		    	      InputStream buffer = new BufferedInputStream(file);
//		    	      ObjectInput input = new ObjectInputStream (buffer);
//		    	    ){
//		    	      //deserialize the List
//		    	      JFrame recoveredQuarks = (JFrame) input.readObject();
//		    	      this.frame.dispose();
//		    	      this.frame = recoveredQuarks;
//		    	      //display its data
////		    	      for(String quark: recoveredQuarks){
////		    	        System.out.println("Recovered Quark: " + quark);
////		    	      }
//		    	    }
//		    	    catch(ClassNotFoundException ex){
//		    	    
//		    	    }
//		    	    catch(IOException ex){
//		    	     
//		    	    }

//			 try {
//				 	
//				 	File loadFile = getFile(false);
////					File file = new File("C:/Users/dachi/git/DnDCharacterApp/DnDCharacterApp/Character/" + "test" + ".char");
//				 	if(loadFile == null){
//				 		return false;
//				 	}
//					JAXBContext jaxbContext = JAXBContext.newInstance(Character.class);
//			
//					Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//					Character playerLoaded = (Character) jaxbUnmarshaller.unmarshal(loadFile);
//					System.out.println(playerLoaded.getName());
//					
//					this.frame.dispose();
////					this.frame.initialize();
//					this.applicationGUI.initialize(playerLoaded);
//			
//				  } catch (JAXBException e) {
//					e.printStackTrace();
//				  }
		this.frame.dispose();
	      try {
	          FileInputStream fileIn = new FileInputStream("employee.ser");
	          ObjectInputStream in = new ObjectInputStream(fileIn);
	          this.frame = (JFrame) in.readObject();
	          in.close();
	          fileIn.close();
	       }catch(IOException i) {
	          i.printStackTrace();
	          return false;
	       }catch(ClassNotFoundException c) {
	          System.out.println("Employee class not found");
	          c.printStackTrace();
	          return false;
	       }
	      this.frame.setVisible(true);
	      this.frame.repaint();
		return true;
	}
	
	
	public boolean loadSpells(){
		 try {
			 
//				File file = new File("C:/Users/dachi/git/DnDCharacterApp/DnDCharacterApp/Character/" + "test" + ".char");
				JAXBContext jaxbContext = JAXBContext.newInstance(Character.class);
		
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				Character playerLoaded = (Character) jaxbUnmarshaller.unmarshal(saveFile);
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
		//C:\Users\adairdg\git\DnDCharaterCreator\DnDCharacterApp\Character
		chooser.setCurrentDirectory(new File("C:/Users/adairdg/git/DnDCharaterCreator/DnDCharacterApp/Character" ));
		//TODO figure out how to filter only characters
//		FileNameExtensionFilter filter = new FileNameExtensionFilter(
//		        "char"); // filter only character files
//		chooser.setFileFilter(filter);
		
		int returnVal = chooser.showOpenDialog(this.frame);
		System.out.println(returnVal);
		//TODO fix this so it saves with .char
//		if(!chooser.getTypeDescription(chooser.getSelectedFile()).equals(".char") && save){
//			chooser.getSelectedFile().renameTo(new File(chooser.getSelectedFile().getAbsolutePath()
//												+ chooser.getName() + ".char"));
//			System.out.println(chooser.getSelectedFile().getAbsolutePath()
//												+ chooser.getName() + ".char");
//		}
		if(returnVal == JFileChooser.APPROVE_OPTION) {
		       System.out.println("You chose to open this file: " +
		            chooser.getSelectedFile().getName());
		    }
		return chooser.getSelectedFile();
	}
}
