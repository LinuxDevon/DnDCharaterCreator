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
	private boolean firstRun;
	private int originalNumber;
	
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
		String newTxt = txt.replaceAll(num, "");
//		System.out.println(num);

		int numberConverted = Integer.parseInt(num);
		
		if(firstRun){
			this.originalNumber = numberConverted;
			this.firstRun = false;
		}
		
		int bonusNum;
//		try{
//			bonusNum = Integer.parseInt(this.bonus.getText());
//		}catch(NumberFormatException exp){
//			JOptionPane.showMessageDialog(this.frame, "Please make sure that the Proficency Bonus text box is a valid int!");
//			return;
//		}
		if(this.bonus.getText().equals("")){
			bonusNum = 0;
		}else{
			bonusNum = Integer.parseInt(this.bonus.getText());
		}

		if(this.button.isSelected()){
//			if(this.lastNum != bonusNum){
//				this.label.setText((numberConverted + bonusNum) + newTxt);
//			}else{
			this.label.setText((numberConverted + bonusNum) + newTxt);
//			}
			
		}else{
//			this.label.setText((numberConverted - bonusNum) + newTxt);
			this.label.setText(this.originalNumber + newTxt);
		}
//		System.out.println(bonusNum);
		lastNum = bonusNum;
		
		
	}


}
