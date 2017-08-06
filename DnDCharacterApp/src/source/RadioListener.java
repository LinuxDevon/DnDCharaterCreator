package source;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JRadioButton;

public class RadioListener implements ActionListener {

	private HashMap<String, Integer> map;
	private String key;
	private JRadioButton button;
	
	public RadioListener(JRadioButton radioButton, String key, HashMap<String, Integer> map){
		this.map = map;
		this.key = key;
		this.button = radioButton;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.button.isSelected()){
			this.map.put(key, 1);
		} else {
			this.map.put(key, 0);
		}

	}

}
