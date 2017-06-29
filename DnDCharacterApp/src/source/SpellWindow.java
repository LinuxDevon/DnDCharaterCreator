package source;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;

public class SpellWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;
	private JTable table_6;
	private JTable table_7;
	private JTable table_8;
	private JScrollPane scrollPane_3;
	private JScrollPane scrollPane_4;
	private JScrollPane scrollPane_5;
	private JScrollPane scrollPane_6;
	private JScrollPane scrollPane_7;
	private JScrollPane scrollPane_8;
	private JTable table_10;
	private JScrollPane scrollPane_9;
	private JLabel lblImage;
	private JButton btnClose;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SpellWindow frame = new SpellWindow();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public SpellWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 928);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow]"));
		
		String[][] data = new String[][]{{""},
										{""},
										{""},
										{""},
										{""},
										{""},
										{""},
										{""},
										{""},
										{""},
										
		};
		String[] column = new String[]{"Cantrip 0"};
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 0,grow");
		
		table = new JTable(data, column);
		scrollPane.setViewportView(table);
		
		scrollPane_3 = new JScrollPane();
		contentPane.add(scrollPane_3, "cell 1 0,grow");
		
		column = new String[]{"Level 1"};
		
		table_1 = new JTable(data, column);
		scrollPane_3.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		contentPane.add(scrollPane_2, "cell 2 0,grow");
		
		column = new String[]{"Level 1"};
		
		table_2 = new JTable(data, column);
		scrollPane_2.setViewportView(table_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1, "cell 0 1,grow");
		
		column = new String[]{"Level 3"};
		
		table_3 = new JTable(data, column);
		scrollPane_1.setViewportView(table_3);
		
		scrollPane_4 = new JScrollPane();
		contentPane.add(scrollPane_4, "cell 1 1,grow");
		
		column = new String[]{"Level 4"};
		
		table_4 = new JTable(data, column);
		scrollPane_4.setViewportView(table_4);
		
		scrollPane_5 = new JScrollPane();
		contentPane.add(scrollPane_5, "cell 2 1,grow");
		
		column = new String[]{"Level 5"};
		
		table_5 = new JTable(data, column);
		scrollPane_5.setViewportView(table_5);
		
		scrollPane_6 = new JScrollPane();
		contentPane.add(scrollPane_6, "cell 0 2,grow");
		
		column = new String[]{"Level 6"};
		
		table_6 = new JTable(data, column);
		scrollPane_6.setViewportView(table_6);
		
		scrollPane_7 = new JScrollPane();
		contentPane.add(scrollPane_7, "cell 1 2,grow");
		
		column = new String[]{"Level 7"};
		
		table_7 = new JTable(data, column);
		scrollPane_7.setViewportView(table_7);
		
		scrollPane_8 = new JScrollPane();
		contentPane.add(scrollPane_8, "cell 2 2,grow");
		
		column = new String[]{"Level 8"};
		
		table_8 = new JTable(data, column);
		scrollPane_8.setViewportView(table_8);
		
		ImageIcon imageIcon = new ImageIcon("Stamina Cost Table.jpg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(250, 250,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		
		btnClose = new JButton("Close");
		contentPane.add(btnClose, "cell 0 3,alignx center,aligny bottom");
		btnClose.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}});
		
		
		lblImage = new JLabel(imageIcon);
		contentPane.add(lblImage, "cell 1 3,alignx center");
		
		scrollPane_9 = new JScrollPane();
		contentPane.add(scrollPane_9, "cell 2 3,grow");
		
		column = new String[]{"Level 9"};
		
		table_10 = new JTable(data, column);
		scrollPane_9.setViewportView(table_10);
		
		// prevent the close button from stopping the program
//		this.addWindowListener(new WindowAdapter(){
//			@Override
//			public void windowClosing(WindowEvent windowEvent){
//				setVisible(false);
//			}
//		});
	}

}
