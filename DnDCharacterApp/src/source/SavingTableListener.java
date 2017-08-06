package source;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SavingTableListener implements DocumentListener {

	private JTable table;
	private Character player;
	private JTextField editor;

	public SavingTableListener(JTable table, Character player, JTextField editor){
		this.table = table;
		this.player = player;
		this.editor = editor;
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		
		int column = this.table.getEditingColumn();
		int row = this.table.getEditingRow();

		System.out.println("" + column + row);
		String text = this.editor.getText();
		this.player.setMainData(column, row, text);
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		int column = this.table.getEditingColumn();
		int row = this.table.getEditingRow();

		String text = this.editor.getText();
		this.player.setMainData(column, row, text);
		
	}

}
