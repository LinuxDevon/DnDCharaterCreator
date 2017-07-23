package source;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class XpListener implements Serializable, DocumentListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3398355866027620921L;
	private JFormattedTextField textBox;
	private JLabel labelToModify;
	private ArrayList<Integer> lvlExp;

	public XpListener(JFormattedTextField frmtdtxtfldXp, JLabel lblLevel, ArrayList<Integer> lvlExp){
		this.textBox = frmtdtxtfldXp;
		this.labelToModify = lblLevel;
		this.lvlExp = lvlExp;
	}
	
	@Override
	public void changedUpdate(DocumentEvent e) {
		// Don't need

	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		if(!textBox.getText().equals("")){
			int lvl;
			try {
				lvl = lvlCalc(Integer.parseUnsignedInt(textBox.getText()));
			}catch (NumberFormatException e1){
				lvl = 19;
			}
			
			labelToModify.setText("Level: " + lvl);
		}


	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		if(!textBox.getText().equals("")){
			int lvl;
			try {
				lvl = lvlCalc(Integer.parseUnsignedInt(textBox.getText()));
			}catch (NumberFormatException e1){
				lvl = 19;
			}
			labelToModify.setText("Level: " + lvl);
		}

	}
	
	public int lvlCalc(int xpAmount){
		int lvl = 0;
		
		for(int i = 0; i <= this.lvlExp.size() - 1; i++){
			if((i + 1) == 20){ // check the end
				lvl = i;
				return lvl;
			}
			if(xpAmount >= this.lvlExp.get(i) && xpAmount < this.lvlExp.get(i + 1)){
				lvl = i + 1;
				return lvl;
			}
		}
		return lvl;
	}

}
