package source;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
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
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;

/**
 * 
 * @author Devon Adair
 *
 *
 *	TODO Allow it so that it saves the text so when reopened the spells appear. Maybe put in character some how.
 *	TODO Comment Code
 */

public class SpellWindow {

	private String[][] data;
	
	private JFrame frame;
	
	public SpellWindow(){
		
	}
	/**
	 * Create the frame.
	 */
	public SpellWindow(Character player) {
		
		frame = new JFrame();
		frame.setTitle("Spell Window");
		frame.setBounds(100, 100, 944, 928);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow]"));
		
		ImageIcon imageIcon = new ImageIcon("Images/Stamina Cost Table.jpg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(250, 250,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		
		JButton btnClose = new JButton("Close");
		contentPane.add(btnClose, "cell 0 3,alignx center,aligny bottom");
		btnClose.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
//				frame.setVisible(false);
				frame.dispose();
				
			}});
		
		
		JLabel lblImage = new JLabel(imageIcon);
		contentPane.add(lblImage, "cell 1 3,alignx center");

		int row = 0, column = 0;
		String[] header;
		for(int i = 0; i < 10; i++){
			int index = i;
			if(i == 0){
				header = new String[]{"Cantrip 0"};
			} else {
				header = new String[]{"Level " + i};
			}
			JScrollPane scrollPane = new JScrollPane();
			contentPane.add(scrollPane, "cell " + column + " " + row + " ,grow");
			
			JTable table = new JTable(player.getSpellTable(i), header);
			scrollPane.setViewportView(table);
			
			if(row == 2){
				row = 0;
				column++;
			} else {
				row++;
			}
			
			if(i == 8){
				column = 2;
				row = 3;
			}
			
			DefaultCellEditor dce = (DefaultCellEditor)table.getDefaultEditor(Object.class);
			JTextField editor = (JTextField)dce.getComponent();
			editor.getDocument().addDocumentListener(new SavingSpellTableListener(table, player, editor, index));
		}
	}

	public void closeWindow(){
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.dispose();
	}
	public void display() {
		this.frame.setVisible(!this.frame.isVisible());
		
	}

}
