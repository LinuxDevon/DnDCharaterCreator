package source;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * This listener is used for buttons to modify the labels associated with the radio buttons and changes the value based on 
 * weather is is clicked or not.
 * 
 * @author Devon Adair
 * 
 * TODO Comment Code
 *
 */
public class RadioListener implements ActionListener {

	private JLabel label;
	private JTextField bonus;
	private JRadioButton button;
	private JFrame frame;
	
	private int lastNum;
	
	public RadioListener(JLabel label, JTextField txtProficiencybonustextbox, JRadioButton rdbtnStrrad, JFrame frame){
		this.label = label;
		this.bonus = txtProficiencybonustextbox;
		this.button = rdbtnStrrad;
		this.frame = frame;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Parse the string to get the integer and recombine into a string
		String txt = this.label.getText();
		String num = txt.replaceAll("[\\D]", "");
		if(txt.startsWith("-")){
			num = "-" + num;
		}
		String newTxt = txt.replaceAll(num, "");

		int numberConverted = Integer.parseInt(num);
		
		int bonusNum;
		try{
			bonusNum = Integer.parseInt(this.bonus.getText());
		}catch(NumberFormatException exp){
			JOptionPane.showMessageDialog(this.frame, "Please make sure that the Proficency Bonus text box is a valid int!");
			return;
		}

		if(this.button.isSelected()){
//			if(this.lastNum != bonusNum){
//				this.label.setText((numberConverted + bonusNum) + newTxt);
//			}else{
			this.label.setText((numberConverted + bonusNum) + newTxt);
//			}
			
		}else{
			this.label.setText((numberConverted - bonusNum) + newTxt);
		}
		lastNum = Integer.parseInt(this.bonus.getText());
		
		
	}



}
