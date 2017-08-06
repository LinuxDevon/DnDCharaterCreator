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
//		setDefaultCloseOperation(JFrame.dispose());
		frame.setTitle("Spell Window");
		frame.setBounds(100, 100, 944, 928);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow]"));
		
		
//		data = new String[][]{{""},
//							{""},
//							{""},
//							{""},
//							{""},
//							{""},
//							{""},
//							{""},
//							{""},
//							{""},
//										
//		};
//		String[] column = new String[]{"Cantrip 0"};
//		
//		JScrollPane scrollPane = new JScrollPane();
//		contentPane.add(scrollPane, "cell 0 0,grow");
//		
//		JTable table = new JTable(player.getSpellTable(0), column);
//		
//		scrollPane.setViewportView(table);

//		DefaultCellEditor dce = (DefaultCellEditor)table.getDefaultEditor(Object.class);
//		JTextField editor = (JTextField)dce.getComponent();
//		editor.getDocument().addDocumentListener(new SavingSpellTableListener(table, player, editor, 0));
//		
//		JScrollPane scrollPane_3 = new JScrollPane();
//		contentPane.add(scrollPane_3, "cell 1 0,grow");
//		
//		column = new String[]{"Level 3"};
//		
//		JTable table_1 = new JTable(player.getSpellTable(1), column);
//		scrollPane_3.setViewportView(table_1);
//		
//		DefaultCellEditor dce1 = (DefaultCellEditor)table.getDefaultEditor(Object.class);
//		JTextField editor1 = (JTextField)dce1.getComponent();
//		editor1.getDocument().addDocumentListener(new SavingSpellTableListener(table_1, player, editor1, 1));
//		
//		JScrollPane scrollPane_2 = new JScrollPane();
//		contentPane.add(scrollPane_2, "cell 2 0,grow");
//		
//		column = new String[]{"Level 6"};
//		
//		JTable table_2 = new JTable(player.getSpellTable(6), column);
//		scrollPane_2.setViewportView(table_2);
//		
//		JScrollPane scrollPane_1 = new JScrollPane();
//		contentPane.add(scrollPane_1, "cell 0 1,grow");
//		
//		column = new String[]{"Level 1"};
//		
//		JTable table_3 = new JTable(player.getSpellTable(1), column);
//		scrollPane_1.setViewportView(table_3);
//		
//		JScrollPane scrollPane_4 = new JScrollPane();
//		contentPane.add(scrollPane_4, "cell 1 1,grow");
//		
//		column = new String[]{"Level 4"};
//		
//		JTable table_4 = new JTable(player.getSpellTable(4), column);
//		scrollPane_4.setViewportView(table_4);
//		
//		JScrollPane scrollPane_5 = new JScrollPane();
//		contentPane.add(scrollPane_5, "cell 2 1,grow");
//		
//		column = new String[]{"Level 7"};
//		
//		JTable table_5 = new JTable(player.getSpellTable(7), column);
//		scrollPane_5.setViewportView(table_5);
//		
//		JScrollPane scrollPane_6 = new JScrollPane();
//		contentPane.add(scrollPane_6, "cell 0 2,grow");
//		
//		column = new String[]{"Level 2"};
//		
//		JTable table_6 = new JTable(player.getSpellTable(2), column);
//		scrollPane_6.setViewportView(table_6);
//		
//		JScrollPane scrollPane_7 = new JScrollPane();
//		contentPane.add(scrollPane_7, "cell 1 2,grow");
//		
//		column = new String[]{"Level 5"};
//		
//		JTable table_7 = new JTable(player.getSpellTable(5), column);
//		scrollPane_7.setViewportView(table_7);
//		
//		JScrollPane scrollPane_8 = new JScrollPane();
//		contentPane.add(scrollPane_8, "cell 2 2,grow");
//		
//		column = new String[]{"Level 8"};
//		
//		JTable table_8 = new JTable(data, column);
//		scrollPane_8.setViewportView(table_8);
		
		ImageIcon imageIcon = new ImageIcon("Images/Stamina Cost Table.jpg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(250, 250,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		
		JButton btnClose = new JButton("Close");
		contentPane.add(btnClose, "cell 0 3,alignx center,aligny bottom");
		btnClose.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				
			}});
		
		
		JLabel lblImage = new JLabel(imageIcon);
		contentPane.add(lblImage, "cell 1 3,alignx center");
		
//		JScrollPane scrollPane_9 = new JScrollPane();
//		contentPane.add(scrollPane_9, "cell 2 3,grow");
//		
//		column = new String[]{"Level 9"};
//		
//		JTable table_9 = new JTable(data, column);
//		scrollPane_9.setViewportView(table_9);
//		
//		ArrayList<JTable> tableList = new ArrayList<>();
//		tableList.addAll(Arrays.asList(table, table_1, table_2, table_3, table_4, table_5, table_6, table_7, table_8,
//										table_9));
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
	
	public JFrame getFrame(){
		return frame;
	}

}
