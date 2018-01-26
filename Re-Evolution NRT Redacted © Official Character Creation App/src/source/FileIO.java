package source;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Document;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.jsoup.Jsoup;
import org.omg.CORBA.portable.InputStream;

/**
 * This class is used to open and read the files that is used to save
 * and load by the program.
 * 
 * @author Devon Adair
 *
 */
public class FileIO {

	private static final String TESTFILE = "C:/Users/dachi/OneDrive/Documents/test.char";
	private static final String FILTERLIST = "char";
	
	private JFrame frame;
	private Application application;

	private Character player;
	
	private String fileName;
	private String currentDirectory;
	
	private String defaultTemp;
	private Path currentRelativePath;
	private String updatePath;
	
	public FileIO(Character player, JFrame frame, Application application){
		this.player = player;
		this.frame = frame;
		this.application = application;
		this.currentDirectory = getCurrentDirectory();
		
		this.defaultTemp = this.currentDirectory + "\\Saves\\temp.char";
		this.updatePath = this.currentDirectory + "\\Update";
		this.fileName = this.defaultTemp;
	}
	
	/**
	 * Verifies that the folders exists. Doesn't check the files
	 * that need to be in the folders though.
	 * 
	 * TODO figure out how to check the files and replace them.
	 */
	public void fileChecker(){
		checkFolderExists("Saves");
		checkFolderExists("Images");
		checkFolderExists("References");
	}
	
	/**
	 * Checks the given folder at the default directory and then creates 
	 * the folder if it isn't there.
	 * 	
	 * @param folderName - name of the folder in the current directory to check
	 */
	private void checkFolderExists(String folderName){
		File fileToCheck = new File(this.currentDirectory + "\\" + folderName);
		if (!fileToCheck.exists()){
			new File(this.currentDirectory + "\\" + folderName);
		}
	}
	
	/**
	 * updates the files such as the main program and the dnd handbook.
	 */
	public void update(){
		Updater updateApp = new Updater(frame, updatePath);
		updateApp.update();
		
	}
	
	/**
	 * Used to pull up the file viewer to choose which file to pick.
	 * This method chops of any extension the user gives and gives
	 * the special extension to ensure that the file is valid.
	 * @throws Exception 
	 */
	public void fileChooser(boolean save) throws Exception {
		JFileChooser chooser = new JFileChooser(this.currentDirectory + "\\Saves");
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        						"char files", FILTERLIST);
		chooser.setFileFilter(filter);
		// TODO this can probably be simplified.
		int returnVal = chooser.showOpenDialog(this.frame);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			
			String fileName = chooser.getSelectedFile().getName();
			String[] fileNameSplit = fileName.split("\\.");
			if(fileNameSplit.length > 1){ // there is already an extension.
				String ext = fileNameSplit[1];
				if(!ext.equals("char") || ext.equals("")){
					if(!save){
						JOptionPane.showMessageDialog(this.frame, "Invalid file name please choose a .char file.");
						throw new Exception("invalid file extension loaded");
					}
					this.fileName = this.currentDirectory + "\\Saves\\" + fileNameSplit[0] + ".char";
					return;
				}
			} else if(fileNameSplit.length == 1){ // no extension found
				if(!save){
					JOptionPane.showMessageDialog(this.frame, "Invalid file name please choose a .char file.");
					throw new Exception("invalid file extension loaded");
				}
				this.fileName = this.currentDirectory + "\\Saves\\" + fileNameSplit[0] + ".char";
				return;
			}
			
			this.fileName = chooser.getSelectedFile().getAbsolutePath();
//				JOptionPane.showMessageDialog(this.frame, this.fileName);
		 } else if (returnVal == JFileChooser.CANCEL_OPTION){
			 throw new Exception("" + JFileChooser.CANCEL_OPTION);
		 }
	}
	
	/**
	 * Method to save to a file that is choosen by the user. 
	 */
	public void save(){
		if(this.fileName.equals(this.defaultTemp)){
			try {
				fileChooser(true);
			} catch (Exception e) {
				if(e.equals(JFileChooser.CANCEL_OPTION)) {
					return;
				} else {
//					JOptionPane.showMessageDialog(this.frame, e);
					return;
				}
			}
			 
		}
		try {
			File file = new File(this.fileName);
//			File file = new File(TESTFILE);
			JAXBContext jaxbContext = JAXBContext.newInstance(Character.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(this.player, file);
//			jaxbMarshaller.marshal(this.player, System.out);

			JOptionPane.showMessageDialog(this.frame, this.fileName + " has saved "
											+ "successfully!");
			
		} catch (JAXBException e) {
//			PrintWriter out;
//			try {
//				out = new PrintWriter(this.currentDirectory + "\\Debug.txt");
//				out.println(e);
//				out.close();
//			} catch (FileNotFoundException e2) {
//				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this.frame, "Unable to save...");
//			}

		}

			
	}	/**
	 * Method to save to a file that is choosen by the user. 
	 */
	public void saveTemp(){
		try {
			File file = new File(this.fileName);
//			File file = new File(TESTFILE);
			JAXBContext jaxbContext = JAXBContext.newInstance(Character.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(this.player, file);

		} catch (JAXBException e) {
			//TODO fix exception eating
			e.printStackTrace();
		}

			
	}

	/**
	 * This method loads the file that user as selected.
	 */
	public void load(){
		try {
			fileChooser(false);
		} catch (Exception e1) {
			// TODO fix exception eating
			if(e1.equals(JFileChooser.CANCEL_OPTION)) {
				return;
			} else {
//				JOptionPane.showMessageDialog(this.frame, e1);
				return;
			}
		}
		
		try {

			File file = new File(this.fileName);
//			File file = new File(TESTFILE);
			JAXBContext jaxbContext = JAXBContext.newInstance(Character.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Character newCharacter = (Character) jaxbUnmarshaller.unmarshal(file);
			
			this.frame.dispose();
			
			JFrame newFrame = new JFrame();
			this.application.initializeCharacter(newCharacter, newFrame);
			this.frame = newFrame;
			this.player = newCharacter;

//			System.out.println(this.player.getData(Character.TOTALPOINTS));
			if(this.player.getData(Character.TOTALPOINTS) == null){
				this.player.calcTotalPoints();
			}
//			JOptionPane.showMessageDialog(this.frame, this.fileName + " has loaded "
//					+ "successfully!");
		} catch (JAXBException e) {
			JOptionPane.showMessageDialog(this.frame, "File is corrupted or in an incorrect format!");
		}
		
	}

	public void saveAs() {
		try {
			fileChooser(true);
		} catch (Exception e) {
			if(e.equals(JFileChooser.CANCEL_OPTION)) {
				return;
			} else {
				JOptionPane.showMessageDialog(this.frame, "Unable to open file!");
				return;
			}
		}
		
		save();
		
	}
	
	private String getCurrentDirectory(){
		currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
//		JOptionPane.showMessageDialog(this.frame, s);
		return s;
	}
	
	private String parseFileVersion(String fileName){
		
		return null;
	}

	public void manualUpdate() {
		try {
			File file = new File(this.currentDirectory + "\\References\\Re-Evolution Players Handbook.pdf");
			Runtime.getRuntime().exec("explorer.exe /select," + file.getAbsolutePath());
			file = new File(this.currentDirectory);
			Runtime.getRuntime().exec("explorer.exe /select," + file.getAbsolutePath());
			
			JOptionPane.showMessageDialog(this.frame, "Please rename the player handbook to the same name as before if you have not already. \n"
															+ "Replace the players handbook with the new copy to update and replace the jar file with the one \n"
															+ "that you downloaded.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
