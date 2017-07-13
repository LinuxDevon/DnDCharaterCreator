package source;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "save")
//@XmlSeeAlso({SpellWindow.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class Character {
	
	// These finals are used to get the data out of the data map
	// e.g. player.getData(Character.NAME);
	public static final String NAME 		= "name";
	public static final String MONEY 		= "money";
	public static final String CLASS 		= "class";
	public static final String RANK 		= "rank";
	public static final String SPECIES 		= "species";
	public static final String VARIANT 		= "variant";
	public static final String AGENTNUM		= "agentNumber";
	
	public static final String STRABILITY 	= "strengthAbility";
	public static final String DEXABILITY	= "dexterityAbility";
	public static final String CONABILITY 	= "constitutionAbility";
	public static final String INTELABILITY	= "intelligenceAbility";
	public static final String WISABILITY 	= "wisdomAbility";
	public static final String INTERABILITY	= "interfacingAbility";
	public static final String CHAABILITY	= "charismaAbility";
	
	public static final String STRMOD		= "strengthMod";
	public static final String DEXMOD		= "dexterityMod";
	public static final String CONMOD		= "constitutionMod";
	public static final String INTELMOD		= "intelligenceMod";
	public static final String WISMOD		= "wisdomMod";
	public static final String INTERMOD		= "interfacingMod";
	public static final String CHAMOD		= "charismaMod";
	
	@XmlElement(name = "xp")
	private int xp;
	
	@XmlElementWrapper(name = "dataList")
	@XmlElement(name = "entry")
	private HashMap<String, String> data; // stores all of the characters information
	
	@XmlElementWrapper(name = "buttons")
	@XmlElement(name = "radioButtons")
	private HashMap<String, Integer> buttonMap;
	

	public Character(){
		// Here because something needs this
	}
	
	public Character(Integer xp, HashMap<String, String> data) {
		this.xp = xp;
		this.data = data;
		this.buttonMap = new HashMap<>();
	}

	public String getName(){
		return this.data.get("name");
	}
	
	public int getXP(){
		return this.xp;
	}
	
	/**
	 * Here you input the string to get the data out of the map. You can do something like this:
	 * 
	 * e.g. Character player = new Character();
	 * 		player.getData(Character.NAME);
	 * 
	 * @param variable - key word see finals of Character
	 * @return - string 
	 */
	public String getData(String variable){
		return this.data.get(variable);
	}
	
	public String modLabelCreator(String key){
		return getData(key + "Mod") + " : " + key;
	}
	
//	public String[][] setTableData(int row, int col){
//		
//	}
//	
//	public String[][] getTableData(){
//		
//	}
	public void setButtonMap(HashMap<JLabel, JRadioButton> buttonMap2){
		for(JLabel button: buttonMap2.keySet()){
//			this.buttonMap.add(buttonMap2.get(i))
			if(buttonMap2.get(button).isSelected()){
				this.buttonMap.put(button.getText(), 1);
			}else{
				this.buttonMap.put(button.getText(), 0);
			}
			
		}
	}

	public HashMap<String, Integer> getButtonMap() {
		return this.buttonMap;
	}
	
	

}
