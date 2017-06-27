package source;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;

import javax.swing.event.DocumentListener;

/**
 * This listens for changes in the text field and changes the total points left to tell how many points they have.
 * 
 * @author Devon Adair
 *
 */
public class DocListener implements DocumentListener {
	
	private JTextField textField;
	private JLabel totalPoints;
	private JLabel modNumber;
	
	private int lastNumberInField;

	public DocListener(JTextField textBox, JLabel labelToChange, JLabel modNumber){
		this.textField = textBox;
		this.totalPoints = labelToChange;
		this.modNumber = modNumber;
		this.lastNumberInField = Integer.parseInt(textBox.getText());
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		try{
			int textNumber = Integer.parseInt(this.textField.getText());
			this.lastNumberInField = textNumber;
			this.totalPoints.setText(""+(Integer.parseInt(this.totalPoints.getText())-Integer.parseInt(this.textField.getText())));
			this.modNumber.setText(""  + modifierCalc(textNumber));
//			this.modNumber.repaint();
		} catch(java.lang.NumberFormatException e){
			System.out.println("Invalid entry"); // don't eat exception!
			
			// Maybe add a color around box at a later time?
//			frmtdtxtfldCharacterinput.setBorder(BorderFactory.createMatteBorder(0, 0, 20, 0, Color.RED));
			
		}

	}
	
	// Need to fix the mod number calculations
	

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		try{
			int textNumber;
			if(this.textField.getText().equals("")){
				textNumber = 0;
			}else{
				textNumber = Integer.parseInt(this.textField.getText());
			}
			this.totalPoints.setText(""+(Integer.parseInt(this.totalPoints.getText())+this.lastNumberInField));
			this.modNumber.setText(""  + modifierCalc(textNumber));
			this.lastNumberInField = Integer.parseInt(this.textField.getText());
			

		} catch(java.lang.NumberFormatException e){
			System.out.println("Invalid entry");
		}
	

	}
	
	
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		//Doesn't apply here

	}

	public int modifierCalc(int abilityScore){
		int abilityMod;
		abilityMod = (int) Math.floor(((abilityScore -10)/2));
		return abilityMod;
	}
}
