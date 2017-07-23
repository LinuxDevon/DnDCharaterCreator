package source;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * This listener is used for buttons to modify the labels associated with the radio buttons and changes the value based on 
 * weather is is clicked or not.
 * 
 * @author Devon Adair
 * 
 *
 */
public class RadioListener implements ActionListener, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6585677725460067454L;
	
	private JLabel label;
	private JTextField bonus;
	private JRadioButton button;
	private JFrame frame;
	
	private int lastNum;
	private boolean firstRun;
	private int originalNumber;
	
	public RadioListener(){
		
	}
	
	public RadioListener(JLabel label, JTextField txtProficiencybonustextbox, JRadioButton rdbtnStrrad, JFrame frame){
		this.label = label;
		this.bonus = txtProficiencybonustextbox;
		this.button = rdbtnStrrad;
		this.frame = frame;
		
		this.firstRun = true;
		this.originalNumber = 0;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Parse the string to get the integer and recombine into a string
		String txt = this.label.getText(); 
		String num = txt.replaceAll("[\\D]", "");
		if(txt.startsWith("-")){
			num = "-" + num;
		}
		// The original string from the label w/out the number
		String newTxt = txt.replaceAll(num, "");

		// number from the label
		int numberConverted = Integer.parseInt(num);
		
		if(firstRun){
			this.originalNumber = numberConverted;
			this.firstRun = false;
		}
		
		// amount to add to the number in the label
		int bonusNum; 

		// check for nothing in the proficency text box
		if(this.bonus.getText().equals("")){
			bonusNum = 0; 	// set to 0 if empty otherwise get the number to add
		}else{
			bonusNum = Integer.parseInt(this.bonus.getText());
		}

		// check if button is selected and add if it is
		if(this.button.isSelected()){
			this.label.setText((numberConverted + bonusNum) + newTxt);
		}else{
			this.label.setText(this.originalNumber + newTxt);
		}

		// a defense to fix a bug
		lastNum = bonusNum;

	}

}
