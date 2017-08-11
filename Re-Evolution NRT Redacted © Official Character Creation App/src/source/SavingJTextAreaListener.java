package source;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SavingJTextAreaListener implements DocumentListener {
	
	private String variableToSet;
	private Character player;
	private JTextArea area;
	
	public SavingJTextAreaListener(String characterVariable, JTextArea area, Character player){
		this.variableToSet = characterVariable;
		this.player = player;
		this.area = area;
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// Don't need
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		this.player.saveVariable(this.variableToSet, this.area.getText());

	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		this.player.saveVariable(this.variableToSet, this.area.getText());

	}

}
