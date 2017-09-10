package source;



import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class XpListener implements DocumentListener {

	private JTextField textBox;
	private JLabel labelToModify;
	private Character player;

	public XpListener(JTextField txtfldXp, JLabel lblLevel, Character player){
		this.textBox = txtfldXp;
		this.labelToModify = lblLevel;
		this.player = player;
	}
	
	@Override
	public void changedUpdate(DocumentEvent e) {
		// Don't need

	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		if(!textBox.getText().equals("")){
			
			
			try {
				this.player.setLevel(textBox.getText());
				this.player.saveVariable(Character.XP, textBox.getText());
				System.out.println("\n insert = " + textBox.getText());
			}catch (NumberFormatException e1){
				this.player.setLevel("0");
				System.out.println("here");
			}
			
			labelToModify.setText("Level: " + this.player.getLevel());
		}


	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		if(!textBox.getText().equals("")){
			
			try {
				this.player.setLevel(textBox.getText());
				this.player.saveVariable(Character.XP, textBox.getText());
				System.out.println("\n removed = " + textBox.getText());
			}catch (NumberFormatException e1){
				this.player.setLevel("0");
				System.out.println("here");
			}
			
			labelToModify.setText("Level: " + this.player.getLevel());
		}

	}
}
