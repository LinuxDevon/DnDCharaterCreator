package source;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Updater {
	private static final String VERSION_PATH = "https://raw.githubusercontent.com/LinuxDevon/Re-Evolution-NRT-Redacted-Official-Character-Creation-App/masterNew/VERSION.txt";
	private static final String JAVA_PATH = "https://github.com/LinuxDevon/Re-Evolution-NRT-Redacted-Official-Character-Creation-App/raw/masterNew/Re-Evolution%20NRT%20Redacted%20%C2%A9%20Official%20Character%20Creation%20App/Update/update.jar";
	private static final String BATCH_PATH = "https://raw.githubusercontent.com/LinuxDevon/Re-Evolution-NRT-Redacted-Official-Character-Creation-App/masterNew/Re-Evolution%20NRT%20Redacted%20%C2%A9%20Official%20Character%20Creation%20App/Update/update.bat";
	private static final String VERSION_FILE = "VERSION.txt";
	private static final String APP_FILE_NAME = "Re-Evolution NRT Redacted Official Character Creation App v";
//	 + Application.FIRST_VERSION_NUMBER
//	+ "." + Application.SECOND_VERSION_NUMBER + "." + Application.THIRD_VERSION_NUMBER + ".jar";
	private static final String BOOK_FILE_NAME = "Re-Evolution Players Handbook.pdf";
	private static final String UPDATE_FILE_NAME = "DnDupdate.txt";
	private static final String UPDATE_SCRIPT_NAME = "update.bat";
	private static final String UPDATE_JAVA_NAME = "update.jar";
	private static final String BOOK_VERSION = "bookVersion.txt";
	
	private JFrame mainFrame;
	private String tempDir;
	private String updatePath;
	private JDialog frame;
	private int bookCurrentThree;
	private int bookCurrentTwo;
	private int bookCurrentOne;
	
	public Updater(JFrame frame, String updatePath) {
		this.mainFrame = frame;
		this.updatePath = updatePath;
		this.tempDir = System.getProperty("java.io.tmpdir");
	}

	public void update(){
		frame = new JDialog(this.mainFrame);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.checkFiles();
		Scanner sc = this.downloadFile(tempDir + "/" + VERSION_FILE, VERSION_PATH);
		this.checkVersion(sc);
	}
	
	private void checkVersion(Scanner sc){
		String fileIn;
    	String[] versions = new String[5];
    	int i = 0;
    	
    	int appVersionOne = 0, appVersionTwo = 0, appVersionThree = 0;
    	int bookVersionOne = 0, bookVersionTwo = 0, bookVersionThree = 0;
    	String[] appLocation = null, bookLocation = null;
    	while (sc.hasNextLine()){
    		fileIn = sc.nextLine();
    		versions[i] = fileIn;
    		if (i == 0){
    			String[] appVersion = versions[i].split(": ");
    			String[] appNumbers = appVersion[1].split("\\.");
    	    	appVersionOne= Integer.parseInt(appNumbers[0]);
    	    	appVersionTwo = Integer.parseInt(appNumbers[1]);
    	    	appVersionThree = Integer.parseInt(appNumbers[2]);
    		} else if (i == 1){
    			String[] bookVersion = versions[i].split(": ");
    			String[] bookNumbers = bookVersion[1].split("\\.");
    			bookVersionOne= Integer.parseInt(bookNumbers[0]);
    			bookVersionTwo = Integer.parseInt(bookNumbers[1]);
    			bookVersionThree = Integer.parseInt(bookNumbers[2]);
    		} else if (i == 2) {
    			appLocation = versions[i].split(": ");
    		} else if (i == 3) {
    			bookLocation = versions[i].split(": ");
    		}
    		i++;
    	}
    	
    	
    	try {
    		File file = new File(this.updatePath + "\\" + BOOK_VERSION);
			sc = new Scanner(file);

			bookCurrentOne = Integer.parseInt(sc.findInLine("\\d+"));
			bookCurrentTwo = Integer.parseInt(sc.findInLine("\\d+"));
			bookCurrentThree = Integer.parseInt(sc.findInLine("\\d+"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

    	if (!checkApp(appVersionOne, appVersionTwo, appVersionThree, appLocation[1]) && checkBook(bookVersionOne, bookVersionTwo, bookVersionThree, bookLocation[1])) {
    		JOptionPane.showMessageDialog(frame, "Update check complete!");
    	} else {
    		JOptionPane.showMessageDialog(frame, "No update found!");
    	}
	}
	
	private Scanner downloadFile(String outputPath, String urlPath) {
		InputStream in = null;
		FileOutputStream fos = null;
		Scanner sc = null;
		
//	    String outputPath = tempDir + "/" + VERSION_FILE;
	    
	    try {
	    	URL url = new URL(urlPath);
	    	URLConnection urlConn = url.openConnection();
	    	
	    	in = urlConn.getInputStream();
	    	
	    	fos = new FileOutputStream(outputPath);
	    	
	    	byte[] buffer = new byte[4096];
	    	int length;
	    	
	    	while ((length = in.read(buffer)) > 0){
	    		fos.write(buffer, 0, length);
	    	}
	    	
	    	File file = new File(outputPath);
	    	sc = new Scanner(file);
    	
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			String error = e.getMessage();
			JOptionPane.showMessageDialog(frame, error);
		} finally {
	    	if (in != null) {
	    		try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					String error = e.getMessage();
					JOptionPane.showMessageDialog(frame, error);
				}
	    	}
	    	if (fos != null) {
	    		try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					String error = e.getMessage();
					JOptionPane.showMessageDialog(frame, error);
				}
	    	}
	    }
	    
	    return sc;
	}
	private boolean checkApp(int first, int second, int third, String appLocation){
		if(first > Application.FIRST_VERSION_NUMBER || 
			second > Application.SECOND_VERSION_NUMBER ||
			third > Application.THIRD_VERSION_NUMBER) {
			if (JOptionPane.showConfirmDialog(this.frame, "UPDATE NEEDED! Have you saved your"
					+ " character? Once you click yes the app will close and update.","Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				this.mainFrame.dispose();
				try {
					URL appLink = new URL(appLocation);
					Path currentRelativePath = Paths.get("");
					String currentDirectory = currentRelativePath.toAbsolutePath().toString();
					String appName = currentDirectory + "\\" + APP_FILE_NAME + first + "." + second + "." + third + ".jar";
					String oldName = currentDirectory + "\\" + APP_FILE_NAME + Application.FIRST_VERSION_NUMBER
									+ "." + Application.SECOND_VERSION_NUMBER + "." + Application.THIRD_VERSION_NUMBER + ".jar";
					Path appFile = Paths.get(appName);
//					Process proc = Runtime.getRuntime().exec("runas /profile /user:Administrator java -jar " + currentDirectory + "\\Update\\update.jar");
					
//					System.out.println("runas /profile /user:Administrator " + "java -jar \"" + currentDirectory + "\\Update\\update.jar" + "\"");
//					System.out.println("runas /profile /user:Administrator " + "\"" + currentDirectory + "\\Update\\update.jar" + "\"");
					System.out.println("HERE");
					InputStream in = appLink.openStream();
					Files.copy(in, appFile, StandardCopyOption.REPLACE_EXISTING);
					System.out.println("HERE");
					FileWriter write = new FileWriter(this.tempDir +  UPDATE_FILE_NAME, false);
					PrintWriter print_line = new PrintWriter(write);
					print_line.println(oldName);
					print_line.println(System.getProperty("user.home") + "\\Desktop\\" + APP_FILE_NAME + Application.FIRST_VERSION_NUMBER
							+ "." + Application.SECOND_VERSION_NUMBER + "." + Application.THIRD_VERSION_NUMBER + ".jar - shortcut");
					print_line.println(appName);
					print_line.println(System.getProperty("user.home") + "\\Desktop\\" + APP_FILE_NAME + first + "." + second + "." + third + ".jar - shortcut");
					print_line.close();
					
//					Runtime.getRuntime().exec("java -jar \"" + currentDirectory + "\\Update\\update.jar" + "\"");
					Runtime.getRuntime().exec("\"" + currentDirectory + "\\Update\\update.bat\" "  + "java -jar \"" + currentDirectory + "\\Update\\update.jar" + "\"");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					String error = e.getMessage();
					JOptionPane.showMessageDialog(frame, "ERROR: " + error);
				}
				return true;
			}
		}
		return false;
	}
	
	private boolean checkBook(int first, int second, int third, String bookLocation){
		
		if(first > this.bookCurrentOne|| 
			second > this.bookCurrentTwo ||
			third > this.bookCurrentThree) {
			if (JOptionPane.showConfirmDialog(this.frame, "Book needs updated! Please confirm that the book"
					+ " is not open in any other application.","Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				try {
					URL appLink = new URL(bookLocation);
					Path currentRelativePath = Paths.get("");
					String currentDirectory = currentRelativePath.toAbsolutePath().toString();
					String appName = currentDirectory + "\\References\\" + BOOK_FILE_NAME;
					Path appFile = Paths.get(appName);
					try (InputStream in = appLink.openStream()) {
					    Files.copy(in, appFile, StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						String error = e.getMessage();
						JOptionPane.showMessageDialog(frame, error);
					}
//					FileOutputStream fos = new FileOutputStream(this.updatePath + "\\" + BOOK_VERSION);
//		    		File file = new File(this.updatePath + "\\" + BOOK_VERSION);
		    		FileWriter fileWriter = new FileWriter(this.updatePath + "\\" + BOOK_VERSION, false);
		    		PrintWriter printer = new PrintWriter(fileWriter);
		    		printer.println("bookVersion: " + first + "." + second + "." + third);
		    		printer.close();
					System.out.println(appName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					String error = e.getMessage();
					JOptionPane.showMessageDialog(frame, error);
				}
				return true;
			}
		}
		return false;
	}
	
	private void checkFiles(){
		String javaFile = this.updatePath + "\\" + UPDATE_JAVA_NAME;
		String batchFile = this.updatePath + "\\" + UPDATE_SCRIPT_NAME;
		
		File fileToCheck = new File(javaFile);
		if (!fileToCheck.exists()){
			this.downloadFile(javaFile, JAVA_PATH);
		}
		fileToCheck = new File(batchFile);
		if (!fileToCheck.exists()){
			this.downloadFile(batchFile, BATCH_PATH);
		}
		
		fileToCheck = new File(this.updatePath + "\\" + BOOK_VERSION);
		if (!fileToCheck.exists()){
    		FileWriter fileWriter;
			try {
				fileWriter = new FileWriter(this.updatePath + "\\" + BOOK_VERSION, false);
	    		PrintWriter printer = new PrintWriter(fileWriter);
	    		printer.println("bookVersion: 0.0.0");
	    		printer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
