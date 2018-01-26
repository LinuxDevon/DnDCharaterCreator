package source;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DiceRoller {

	private JDialog frame;
	private int total;
	
    private JTextField numberOfDice;
    private JTextField numberOfSides;
    private JTextField modifier;
	
    private JRadioButton addButton;
    private JRadioButton subButton;
    
    private JButton rollButton;
    
    private JLabel result;
    
	public DiceRoller(JFrame mainFrame){
		this.frame = new JDialog(mainFrame);
		this.frame.setTitle("Dice Roller");
		this.frame.setMinimumSize(new Dimension(470,100));
		this.frame.setResizable(false);
		this.frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.frame.setLayout(new GridBagLayout());
	    
		this.numberOfDice = new JTextField("0");
		this.numberOfSides = new JTextField("0");
		this.modifier = new JTextField("0");
	    
	    this.addButton = new JRadioButton();
	    this.subButton = new JRadioButton();
	    
		this.result = new JLabel("0");
	    
	    this.addButton.setSelected(true);
	    this.subButton.setSelected(false);
	    
	    ButtonGroup radioButtons = new ButtonGroup();
	    radioButtons.add(this.addButton);
	    radioButtons.add(this.subButton);
	    
	    this.rollButton = new JButton("Roll");
	    this.rollButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int dice, sides, mod; 
				try {
					dice = Integer.parseInt(numberOfDice.getText());
					sides = Integer.parseInt(numberOfSides.getText());
					mod = Integer.parseInt(modifier.getText());
					if(mod >= 1000 || sides >= 1000 || dice >= 1000){
						return;
					}
				} catch (NumberFormatException | NullPointerException ex)
				{
					return;
				}
				int total = 0;
				for(int i = 0; i < dice; i++){
					Random rand = new Random();
					try {
						total += rand.nextInt(sides) + 1;
					} catch (Exception e) {
						// this exception is if there is 0 in the text fields.
						// need to figure out if i need it
//						e.printStackTrace(); // do nothing...
					}
				}
				if(addButton.isSelected()){
					total += mod;
				} else {
					total -= mod;
				}
				result.setText(String.valueOf(total));
			}});
	    
	    addToGrid();
	    
	}
	
	private void addToGrid(){
		JLabel diceNumber = new JLabel("Number of Dice");
		JLabel diceSides = new JLabel("Number of Side");
		JLabel modifierLabel = new JLabel("Modifier");
		JLabel resultLabel = new JLabel("Total");
		JLabel diceLabel = new JLabel("d");
		JLabel addLabel = new JLabel("+");
		JLabel subLabel = new JLabel("-");
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(5,5,5,5);
		c.weightx = 10;
		c.weighty = 10;
		c.gridx = 0;
		c.gridy = 0;
		this.frame.add(diceNumber, c);
		c.gridx = 2;
		this.frame.add(diceSides, c);
		c.gridx = 3;
		this.frame.add(addLabel, c);
		c.gridx = 4;
		this.frame.add(subLabel, c);
		c.gridx = 5;
		this.frame.add(modifierLabel, c);
		c.gridx = 7;
		this.frame.add(resultLabel, c);
		c.gridy = 1;
		c.gridx = 0;
		this.frame.add(numberOfDice, c);
		c.gridx = 1;
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(5,5,5,0);
		this.frame.add(diceLabel, c);
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(5,5,5,5);
		c.gridx = 2;
		this.frame.add(numberOfSides, c);
		c.gridx = 3;
		this.frame.add(addButton, c);
		c.gridx = 4;
		this.frame.add(subButton, c);
		c.gridx = 5;
		this.frame.add(modifier, c);
		c.gridx = 6;
		this.frame.add(rollButton, c);
		c.gridx = 7;
		this.frame.add(result, c);
	}
	
	public void closeWindow() {
		this.frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.frame.dispose();
	}
	
	public void display() {
		this.frame.setVisible(!this.frame.isVisible());
	}

}
