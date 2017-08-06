package source;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * This class is used to open and read the files that is used to save
 * and load by the program.
 * 
 * @author Devon Adair
 *
 */
public class FileIO {

	private static final String TESTFILE = "C:/Users/dachi/OneDrive/Documents/test.xml";
	private static final String FILTERLIST = "xml";
	
	private JFrame frame;
	private Application application;

	private Character player;
	
	private String fileName;
	private String currentDirectory;
	
	private String defaultTemp;
	
	// TODO add in the file checker
	public FileIO(Character player, JFrame frame, Application application){
		this.player = player;
		this.frame = frame;
		this.application = application;
		this.currentDirectory = getCurrentDirectory();
		
		this.defaultTemp = this.currentDirectory + "/Saves/temp.xml";
		this.fileName = this.defaultTemp;
	}
	
	/**
	 * Used to pull up the file viewer to choose which file to pick.
	 * This method chops of any extension the user gives and gives
	 * the special extension to ensure that the file is valid.
	 * @throws Exception 
	 */
	public void fileChooser() throws Exception{
		JFileChooser chooser = new JFileChooser(this.currentDirectory + "/Saves");
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        						"xml files", FILTERLIST);
		chooser.setFileFilter(filter);
		// TODO add in the check for .char file
		int returnVal = chooser.showOpenDialog(this.frame);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
		       this.fileName = chooser.getSelectedFile().getAbsolutePath();
//				JOptionPane.showMessageDialog(this.frame, this.fileName);
		 } else{
			 throw new Exception("Invalid choice");
		 }
	}
	
	/**
	 * Method to save to a file that is choosen by the user. 
	 */
	public void save(){
		if(this.fileName.equals(this.defaultTemp)){
			try {
				fileChooser();
			} catch (Exception e) {
				return;
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
			//TODO fix exception eating
			e.printStackTrace();
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
	public void load() {
		try {
			fileChooser();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			return;
		}
		this.frame.dispose();
		try {

			File file = new File(this.fileName);
//			File file = new File(TESTFILE);
			JAXBContext jaxbContext = JAXBContext.newInstance(Character.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Character newCharacter = (Character) jaxbUnmarshaller.unmarshal(file);
			JFrame newFrame = new JFrame();
			this.application.initializeCharacter(newCharacter, newFrame);
			this.frame = newFrame;
			this.player = newCharacter;

			JOptionPane.showMessageDialog(this.frame, this.fileName + " has loaded "
					+ "successfully!");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}

	public void saveAs() {
		try {
			fileChooser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return;
		}
		save();
		
	}
	
	private String getCurrentDirectory(){
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
//		JOptionPane.showMessageDialog(this.frame, s);
		return s;
	}
}
