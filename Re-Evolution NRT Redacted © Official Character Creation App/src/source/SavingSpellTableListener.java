package source;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SavingSpellTableListener implements DocumentListener {

	private JTable table;
	private Character player;
	private JTextField editor;
	private int index;

	public SavingSpellTableListener(JTable table, Character player, JTextField editor, int index){
		this.table = table;
		this.player = player;
		this.editor = editor;
		this.index = index;
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		
		int column = this.table.getEditingColumn();
		int row = this.table.getEditingRow();

		String text = this.editor.getText();
		if( column == -1 || row == -1 ) {
			return;
		}
		this.player.setSpellTable(index, column, row, text);
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		int column = this.table.getEditingColumn();
		int row = this.table.getEditingRow();

		String text = this.editor.getText();
		if( column == -1 || row == -1 ) {
			return;
		}
		this.player.setSpellTable(index, column, row, text);
		
	}

}
