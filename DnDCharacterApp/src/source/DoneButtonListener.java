package source;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;

public class DoneButtonListener implements ActionListener {
//	private Character player;
	private ApplicationGUI window;
	private NewCharacterWindow characterwindow;
	private JFormattedTextField xp;
	private JFormattedTextField name;

	public DoneButtonListener(Character player, ApplicationGUI window, NewCharacterWindow newCharacterWindow, JFormattedTextField formattedStartingXP, JFormattedTextField frmtdtxtfldCharacterinput) {
//		this.player = player;
		this.window = window;
		this.characterwindow = newCharacterWindow;
		this.name = frmtdtxtfldCharacterinput;
		this.xp = formattedStartingXP;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
//		player = new Character(this.name.getText(), Integer.valueOf(this.xp.getText()), null);

//		System.out.println(this.player.getXP());
		this.characterwindow.dispose(); // kill the frame
//		this.window.initialize();

	}

}
