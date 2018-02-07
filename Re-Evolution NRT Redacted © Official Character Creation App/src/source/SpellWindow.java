package source;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;

/**
 * 
 * @author Devon Adair
 *
 *
 *         TODO Allow it so that it saves the text so when reopened the spells
 *         appear. Maybe put in character some how. TODO Comment Code
 */

public class SpellWindow {

	private String[][] data;

	private JFrame frame;

	public SpellWindow() {

	}

	/**
	 * Create the frame.
	 */
	public SpellWindow(Character player, JFrame mainFrame) {

//		frame = new JDialog();
//		frame = new JDialog(mainFrame);
		frame = new JFrame();
		frame.setTitle("Spell Window");
		frame.setBounds(100, 100, 944, 928);
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow]"));

		ImageIcon imageIcon = new ImageIcon("Images/Stamina Cost Table.jpg"); 
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH); 
		imageIcon = new ImageIcon(newimg); // transform it back

//		JButton btnClose = new JButton("Close");
////		contentPane.add(btnClose, "cell 0 3,alignx center,aligny bottom");
//		contentPane.add(btnClose, "cell 0 3,aligny bottom");
//		btnClose.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// frame.setVisible(false);
//				frame.dispose();
//
//			}
//		});

		JLabel linkInstructions = new JLabel("CTRL + Right Click on spell to open webpage.");
		contentPane.add(linkInstructions, "cell 0 3,alignx center,aligny center");
		
		JLabel lblImage = new JLabel(imageIcon);
		contentPane.add(lblImage, "cell 1 3,alignx center");

		int row = 0, column = 0;
		String[] header;
		for (int i = 0; i < 10; i++) {
			int index = i;
			if (i == 0) {
				header = new String[] { "Cantrip 0" };
			} else {
				header = new String[] { "Level " + i };
			}
			JScrollPane scrollPane = new JScrollPane();
			contentPane.add(scrollPane, "cell " + column + " " + row + " ,grow");

			JTable table = new JTable(player.getSpellTable(i), header);
			table.setCellSelectionEnabled(false);

			DefaultCellEditor dc = (DefaultCellEditor) table.getDefaultEditor(Object.class);
			JTextField field = (JTextField) dc.getComponent();

			// field.addKeyListener(new KeyAdapter(){
			//
			// @Override
			// public void keyPressed(KeyEvent arg0) {
			// if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
			// int column = table.getEditingColumn();
			// int row = table.getEditingRow();
			// System.out.println("enter pressed in row:" + row + " column:"+
			// column);
			// if( column == -1 || row == -1 ) {
			// return;
			// }
			// String text = field.getText();
			// linkify(text, table, row, column);
			// }
			//
			// }
			//
			// @Override
			// public void keyReleased(KeyEvent e) {
			// // TODO Auto-generated method stub
			//
			// }
			//
			// @Override
			// public void keyTyped(KeyEvent e) {
			//// if(e.getKeyCode() == KeyEvent.VK_ENTER){
			//// System.out.println("here");
			//// int column = table.getEditingColumn();
			//// int row = table.getEditingRow();
			////
			////// String text = editor.getText();
			//// if( column == -1 || row == -1 ) {
			//// return;
			//// }
			////// checkSpellLink(text);
			//// }
			// }});
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.isControlDown() && SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {
						int row = table.rowAtPoint(e.getPoint());
						int column = table.columnAtPoint(e.getPoint());
						// System.out.println("enter pressed in row:" + row + "
						// column:"+ column);
						String text = (String) table.getValueAt(row, column);
						tryOpenLink(text);
					}
				}
			});

			// table.addFocusListener(new FocusAdapter() {
			// @Override
			// public void focusLost(FocusEvent e) {
			//
			// }
			// });
			scrollPane.setViewportView(table);

			if (row == 2) {
				row = 0;
				column++;
			} else {
				row++;
			}

			if (i == 8) {
				column = 2;
				row = 3;
			}

			DefaultCellEditor dce = (DefaultCellEditor) table.getDefaultEditor(Object.class);
			JTextField editor = (JTextField) dce.getComponent();
			editor.getDocument().addDocumentListener(new SavingSpellTableListener(table, player, editor, index));

			JPopupMenu popMenu = new JPopupMenu();
			// table.addMouseListener(new MouseListener(){
			//
			// @Override
			// public void mouseClicked(MouseEvent arg0) {
			// // TODO Auto-generated method stub
			//
			// }
			//
			// @Override
			// public void mouseEntered(MouseEvent e) {
			// // TODO Auto-generated method stub
			//
			// }
			//
			// @Override
			// public void mouseExited(MouseEvent e) {
			// // TODO Auto-generated method stub
			//
			// }
			//
			// @Override
			// public void mousePressed(MouseEvent e) {
			// // TODO Auto-generated method stub
			//
			// }
			//
			// @Override
			// public void mouseReleased(MouseEvent e) {
			// if (e.isPopupTrigger()) {
			// popMenu.show(e.getComponent(), e.getX(), e.getY());
			// }
			//
			// }});
		}
	}

	public void closeWindow() {
		this.frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.frame.dispose();
	}

	public void display() {
		this.frame.setVisible(!this.frame.isVisible());

	}

	public boolean checkAlive() {
		return this.frame.isVisible();
	}
	
	private void tryOpenLink(String input) {
		input = makeLinkable(input);
		int code = checkURL(input);
		if (code == 200) {
			// means found web page
			try {
				Desktop.getDesktop().browse(new URL("http://thebombzen.github.io/grimoire/spells/" + input).toURI());	
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(frame, "Spell not found on Grimorie. Please check spelling and spacing.");			
		}

	}

	private void linkify(String input, JTable table, int row, int column) {
		int code = checkURL(input);
		if (code == 200) {
			DefaultTableCellRenderer defRender = (DefaultTableCellRenderer) table.getCellRenderer(row, column);
			Component cellRenderer = defRender.getTableCellRendererComponent(table, null, true, true, row, column);
			cellRenderer.setForeground(Color.GREEN);
		}
	}

	private String makeLinkable(String input) {
		// add in the char to trim the text
		input = input.replaceAll("[*-]", "");
		input = input.toLowerCase();
		input = input.replaceAll(" ", "-");
		return input;
	}

	private int checkURL(String in) {

		// System.out.println(in);
		int code = 404;
		try {
			URL u = new URL("https://thebombzen.com/grimoire/spells/" + in);
			// System.out.println("https://thebombzen.com/grimoire/spells/" +
			// in);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			huc.setRequestMethod("GET"); // OR huc.setRequestMethod ("HEAD");
			huc.connect();
			code = huc.getResponseCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return code;
	}
}
