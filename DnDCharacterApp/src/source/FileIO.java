package source;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * This is to save and load character files. It also verifies all the locations need are created.
 * 
 * The character files are xml files saved as .char. There might be a settings file in a later version.
 * 
 * @author Devon Adair
 *
 */
public class FileIO {
	
	String decodedPath;
	
	public FileIO(){
		// Get the Current Location of File
        String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        
        try {
			decodedPath = URLDecoder.decode(path, "UTF-8");
			System.out.println(decodedPath);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Checks to make sure that
	 */
	public void check() {
//		Path path = null; 
//		try {
//			path = Paths.get(ApplicationGUI.class.getProtectionDomain().getCodeSource().getLocation().toURI());
//			JFrame frame = new JFrame();
//			JLabel label = new JLabel(String.valueOf(path));
//			frame.setSize(100, 100);
//			frame.add(label);
//			frame.setVisible(true);
//			
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		File characterFile = new File(decodedPath + "/Character");
		if(!characterFile.exists()){
			characterFile.mkdirs();
		}

		
	}
	
	public void createCharacter(){
		
	}
	
	public boolean saveCharacter(String location){

        
        String filePath = decodedPath + "/Character/" + location + ".xml";
//        String filePath = "C:/Users/dachi/git/DnDCharacterApp/DnDCharacterApp/Character/" + location + ".char";

        
		try {

			
			File savingFile = new File(filePath);

	        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

	        // root elements
	        Document doc = docBuilder.newDocument();
	        Element rootElement = doc.createElement("company");
	        doc.appendChild(rootElement);

	        // staff elements
	        Element staff = doc.createElement("Staff");
	        rootElement.appendChild(staff);

	        // set attribute to staff element
	        Attr attr = doc.createAttribute("id");
	        attr.setValue("1");
	        staff.setAttributeNode(attr);

	        // shorten way
	        // staff.setAttribute("id", "1");

	        // firstname elements
	        Element firstname = doc.createElement("firstname");
	        firstname.appendChild(doc.createTextNode("yong"));
	        staff.appendChild(firstname);

	        // lastname elements
	        Element lastname = doc.createElement("lastname");
	        lastname.appendChild(doc.createTextNode("mook kim"));
	        staff.appendChild(lastname);

	        // nickname elements
	        Element nickname = doc.createElement("nickname");
	        nickname.appendChild(doc.createTextNode("mkyong"));
	        staff.appendChild(nickname);

	        // salary elements
	        Element salary = doc.createElement("salary");
	        salary.appendChild(doc.createTextNode("100000"));
	        staff.appendChild(salary);
	        
//	        // Get the Current Location of File
//	        String path = FileIO.class.getProtectionDomain().getCodeSource().getLocation().getPath();
//	        String decodedPath;
//	        try {
//				decodedPath = URLDecoder.decode(path, "UTF-8");
//				System.out.println(decodedPath);
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return false;
//			}
//	        
	        // write the content into xml file
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult(filePath);

	        // Output to console for testing
	        // StreamResult result = new StreamResult(System.out);

	        transformer.transform(source, result);

	        System.out.println("File saved!");

	      } catch (ParserConfigurationException pce) {
	        pce.printStackTrace();
	      } catch (TransformerException tfe) {
	        tfe.printStackTrace();
	      }
		
		return true;
	}
	
	public boolean loadCharacter(){
		return true;
	}
	
}
