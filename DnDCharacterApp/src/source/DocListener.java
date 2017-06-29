package source;
import java.util.ArrayList;

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
	private ArrayList<JTextField> textboxes;

	public DocListener(JTextField textBox, JLabel labelToChange, JLabel modNumber, ArrayList<JTextField> textBoxList){
		this.textField = textBox;
		this.totalPoints = labelToChange;
		this.modNumber = modNumber;
		this.lastNumberInField = Integer.parseInt(textBox.getText());
		this.textboxes = textBoxList;
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		int textNumber = 0;
		try{
			textNumber = Integer.parseInt(this.textField.getText());
			
			if(textNumber >= 50){
				textNumber = 50;
				this.textField.setEnabled(false);
				this.textField.setText("50");
			}
//				else if(textNumber < 0){
//				textNumber = 0;
//				return;
//			}
			this.lastNumberInField = textNumber;
			this.totalPoints.setText(""+(Integer.parseInt(this.totalPoints.getText())-Integer.parseInt(this.textField.getText())));
			this.modNumber.setText(""  + modifierCalc(textNumber));
//			this.modNumber.repaint();
		} catch(java.lang.NumberFormatException e){
			System.out.println("Invalid entry"); // don't eat exception!
			
			// Maybe add a color around box at a later time?
//			frmtdtxtfldCharacterinput.setBorder(BorderFactory.createMatteBorder(0, 0, 20, 0, Color.RED));
			
		}
//		this.checkValid(textNumber);
		this.textField.setEnabled(true);
	}
	
	// Need to fix the mod number calculations
	

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		int textNumber = 0;
		try{
			
			if(!this.textField.getText().equals("")){
				textNumber = Integer.parseInt(this.textField.getText());
			}
			this.totalPoints.setText(""+(Integer.parseInt(this.totalPoints.getText())+this.lastNumberInField));
			this.modNumber.setText(""  + modifierCalc(textNumber));
			this.lastNumberInField = Integer.parseInt(this.textField.getText());
			

		} catch(java.lang.NumberFormatException e){
			System.out.println("Invalid entry");
		}
		
//		this.checkValid(textNumber);

	}
	
	
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		//Doesn't apply here

	}

	/**
	 * Calculate the modifier score based on the ability score.
	 * 
	 * @param abilityScore
	 * @return mod score as an int
	 */
	public int modifierCalc(int abilityScore){
		int abilityMod;
		abilityMod = (int) Math.floor(((abilityScore -10)/2));
		return abilityMod;
	}
	
	public void checkValid(int textNumber){
		int total = 0;
//		int valueOf = Integer.parseInt(this.textField.getText());
		int valueOf = textNumber;
		for(JTextField text: this.textboxes){
			try{
				total += Integer.parseInt(text.getText());
			}catch(NumberFormatException error){
				total += 0;
			}
			
		}
		int valueWithout = total - valueOf;
		if(total != Integer.parseInt(this.totalPoints.getText())){
			this.totalPoints.setText("" + total);
		}
	}
}
