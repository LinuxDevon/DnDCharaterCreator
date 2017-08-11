package source;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SavingJTextFieldListener implements DocumentListener {
	
	private String variableToSet;
	private Character player;
	private JTextField field;
	
	public SavingJTextFieldListener(String characterVariable, JTextField field, Character player){
		this.variableToSet = characterVariable;
		this.player = player;
		this.field = field;
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// Don't need
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		this.player.saveVariable(this.variableToSet, this.field.getText());

	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		this.player.saveVariable(this.variableToSet, this.field.getText());

	}

}
