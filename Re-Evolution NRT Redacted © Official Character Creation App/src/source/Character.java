package source;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement // This is the xml creater to restore the variables to the state
				// they were in
@XmlAccessorType(XmlAccessType.FIELD)
public class Character {

	// These finals are used to get the data out of the data map
	// e.g. player.getData(Character.NAME);
	public static final String NAME = "name";
	public static final String MONEY = "money";
	public static final String CLASS = "class";
	public static final String VARIANT = "variant";
	public static final String SPECIES = "species";
	public static final String AGE = "age";
	public static final String STATUS = "status";
	public static final String XP = "xp";
	public static final String SPEED = "speed";
	public static final String AC = "ac";
	public static final String TOTALPOINTS = "total";
	public static final String INSPIRATION = "inspiraton";
	public static final String PROFICIENCY = "proficiency";
	public static final String TITLE1 = "title1";
	public static final String TITLE2 = "title2";
	public static final String TEXTAREA1 = "textArea1";
	public static final String TEXTAREA2 = "textArea2";
	public static final String TEXTAREA3 = "textArea3";
	public static final String CURHITPNTS = "currentHitPoints";
	public static final String MAXHITPNTS = "maxHitPoints";
	public static final String CURSTAMPNTS = "currentStaminaPoints";
	public static final String MAXSTAMPNTS = "maxStaminaPoints";
	public static final String SPELLCASTING = "spellCastingAbility";
	public static final String ABLSAVEDC 	= "revoAbilitySaveDC";
	public static final String ABLATTMOD 	= "revoAbilityAttackMod";
	public static final String LEVEL		= "level";	

	public static final String SUCCESS1 = "success1";
	public static final String SUCCESS2 = "success2";
	public static final String SUCCESS3 = "success3";
	public static final String FAILURE1 = "failure1";
	public static final String FAILURE2 = "failure2";
	public static final String FAILURE3 = "failure3";

	public static final String STRABILITY = "strengthAbility";
	public static final String DEXABILITY = "dexterityAbility";
	public static final String CONABILITY = "constitutionAbility";
	public static final String INTELABILITY = "intelligenceAbility";
	public static final String WISABILITY = "wisdomAbility";
	public static final String INTERABILITY = "interfacingAbility";
	public static final String CHAABILITY = "charismaAbility";

	public static final String STRMOD = "strengthMod";
	public static final String DEXMOD = "dexterityMod";
	public static final String CONMOD = "constitutionMod";
	public static final String INTELMOD = "intelligenceMod";
	public static final String WISMOD = "wisdomMod";
	public static final String INTERMOD = "interfacingMod";
	public static final String CHAMOD = "charismaMod";

	private static final ArrayList<String> savingThrowBaseModifierList = new ArrayList<>(
			Arrays.asList(STRMOD, DEXMOD, CONMOD, INTELMOD, WISMOD, INTERMOD, CHAMOD));
	
	private static final ArrayList<String> abilityScoreList = new ArrayList<>(
			Arrays.asList(STRABILITY, DEXABILITY, CONABILITY, INTELABILITY, WISABILITY, INTERABILITY, CHAABILITY));

	private static final ArrayList<String> skillLabelBasModifierList = new ArrayList<>(
			Arrays.asList(DEXMOD, WISMOD, STRMOD, CHAMOD, INTELMOD, WISMOD, CHAMOD, INTELMOD, INTERMOD, WISMOD,
					INTELMOD, WISMOD, CHAMOD, CHAMOD, INTERMOD, INTELMOD, DEXMOD, DEXMOD, WISMOD, INTERMOD));
	
	String[][] BLANKSPELLS = new String[][]{{""},
														{""},
														{""},
														{""},
														{""},
														{""},
														{""},
														{""},
														{""},
														{""},
																		
													};
													
	public static final ArrayList<Integer> LVLEXP = new ArrayList<>(Arrays.asList(0,300,900,2700,6500,14000,23000,34000,48000,
									64000,85000,100000,120000,140000,165000,195000,
									225000,265000,305000,355000));
	@XmlElement(name = "xp")
	private int xp;

	@XmlElementWrapper(name = "dataList")
	@XmlElement(name = "entry")
	private HashMap<String, String> data; // stores all of the characters
											// information.
											// there is proabably a more simple
											// way of doing this
											// but it was a temporary fix to
											// save data.

	@XmlElementWrapper(name = "buttonList")
	@XmlElement(name = "button")
	private HashMap<String, Integer> radioButtonsList;

	@XmlElement(name = "mainTable")
	private String mainData[][];

	@XmlElement(name = "hitDice")
	private int hitDice;

	@XmlElementWrapper(name = "deathList")
	@XmlElement(name = "DeathSaves")
	private HashMap<String, Boolean> deathSaves;
	
	@XmlElementWrapper(name = "spellList")
	@XmlElement(name = "Spells")
	private HashMap<Integer, String[][]> spells;
	

	/**
	 * Default setup for a character.
	 */
	public Character() {
		// this.xp = 0;
		this.data = new HashMap<>();
		this.radioButtonsList = new HashMap<>();
		this.deathSaves = new HashMap<>();
		this.spells = new HashMap<>();
		
		// TODO create loops to simplifiy
		data.put("strengthAbility", "8");
		data.put("dexterityAbility", "8");
		data.put("constitutionAbility", "8");
		data.put("intelligenceAbility", "8");
		data.put("wisdomAbility", "8");
		data.put("interfacingAbility", "8");
		data.put("charismaAbility", "8");

		data.put(Character.TOTALPOINTS, "31");
		
		data.put("strengthMod", "-1");
		data.put("dexterityMod", "-1");
		data.put("constitutionMod", "-1");
		data.put("intelligenceMod", "-1");
		data.put("wisdomMod", "-1");
		data.put("interfacingMod", "-1");
		data.put("charismaMod", "-1");

		data.put("name", "");
		data.put("money", "");
		data.put("class", "");
		data.put(VARIANT, "");
		data.put("species", "");
		data.put(AGE, "");
		data.put(STATUS, "");
		data.put("xp", "");
		data.put("speed", "");
		data.put("ac", "");
		data.put("inspiration", "");
		data.put("proficiency", "");
		data.put(LEVEL, "");

		data.put(TITLE1, "Changeable Title");
		data.put(TITLE2, "Changeable Title");
		data.put(TEXTAREA1, "");
		data.put(TEXTAREA2, "");
		data.put(TEXTAREA3, "");

		data.put(CURHITPNTS, "");
		data.put(MAXHITPNTS, "");
		data.put(CURSTAMPNTS, "");
		data.put(MAXSTAMPNTS, "");
		data.put(SPELLCASTING, "");
		data.put(ABLATTMOD, "");
		data.put(ABLSAVEDC, "");

		this.hitDice = 0;

		for (String labelName : CharacterWindow.savingThrowList) {
			this.radioButtonsList.put(labelName, 0);
		}

		for (String labelName : CharacterWindow.skillLabelList) {
			this.radioButtonsList.put(labelName, 0);
		}

		for (int i = 0; i < 3; i++) {
			String labelSuccess = "success" + (i + 1);
			String labelFailure = "failure" + (i + 1);
			this.deathSaves.put(labelFailure, false);
			this.deathSaves.put(labelSuccess, false);
		}

		this.mainData = new String[][] { { "", "", "", "", "", "" }, { "", "", "", "", "", "" },
				{ "", "", "", "", "", "" }, { "", "", "", "", "", "" }, { "", "", "", "", "", "" },
				{ "", "", "", "", "", "" }, { "", "", "", "", "", "" }, { "", "", "", "", "", "" } };
				
		for(int i = 0; i < 10; i++){
			this.BLANKSPELLS = new String[][]{{""},
												{""},
												{""},
												{""},
												{""},
												{""},
												{""},
												{""},
												{""},
												{""},
																
												};
			this.spells.put(i, this.BLANKSPELLS);
		}
	}

	/**
	 * Used by the newcharacter window to set up the new character.
	 * 
	 * @param xp
	 *            - integer of the xp amount
	 * @param data
	 *            - stores the information about the character with the key that
	 *            is declared as a final in character
	 * @param radioButtonsList
	 *            - stores the information about the radio button states
	 */
	public Character(HashMap<String, String> data, HashMap<String, Integer> radioButtonsList,
			HashMap<String, Boolean> deathSaves, int diceCombo) {
		// this.xp = xp;
		this.data = data;
		this.radioButtonsList = radioButtonsList;
		this.deathSaves = deathSaves;
		this.spells = new HashMap<>();

		for(int i = 0; i < 10; i++){
			this.BLANKSPELLS = new String[][]{{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
				{""},
								
				};
				this.spells.put(i, this.BLANKSPELLS);

		}
		
		this.hitDice = diceCombo;
		this.mainData = new String[][] { { "", "", "", "", "", "" }, { "", "", "", "", "", "" },
				{ "", "", "", "", "", "" }, { "", "", "", "", "", "" }, { "", "", "", "", "", "" },
				{ "", "", "", "", "", "" }, { "", "", "", "", "", "" }, { "", "", "", "", "", "" } };
	}

	public String getData(String key) {
		return this.data.get(key);
	}

	public int getRadioButton(String key) {
		return this.radioButtonsList.get(key);
	}

	public String getRadioButtonModifier(ArrayList<String> listToSearch, String key) {
		int index = listToSearch.indexOf(key);
		String modifierToFind;
		if (listToSearch.size() == 7) { // length of the skills list length
			modifierToFind = savingThrowBaseModifierList.get(index);
		} else {
			modifierToFind = skillLabelBasModifierList.get(index);
		}

		return getData(modifierToFind);
	}
	
	public String getModifier(ArrayList<String> listToSearch, String key) {
		int index = listToSearch.indexOf(key);
		String modifierToFind;
		if (listToSearch.size() == 7) { // length of the skills list length
			modifierToFind = savingThrowBaseModifierList.get(index);
		} else {
			modifierToFind = skillLabelBasModifierList.get(index);
		}

		return modifierToFind;
	}

	public void saveVariable(String variableToSet, String value) {
		this.data.put(variableToSet, value);

	}

//	private void setData(String key, String newValue){
//		this.data.put(key, newValue);
//	}
	public String[][] getMainTableData() {
		return this.mainData;
	}

	public void setMainData(int column, int row, String data) {
		System.out.println(column + ":" + row);
		this.mainData[row][column] = data;

	}

	public int getDiceCombo() {
		return this.hitDice;
	}

	public void setDiceCombo(int index) {
		this.hitDice = index;
	}

	public void setDeathSaves(String key, boolean selectedTrue) {
		this.deathSaves.put(key, selectedTrue);
	}

	public boolean getDeathSaves(String key) {
		return this.deathSaves.get(key);
	}
	
	public void edit(HashMap<String, String> data, HashMap<String, Integer> radioButtonsList){
		for(String key: data.keySet()){
			this.data.put(key, data.get(key));
		}
		
		this.radioButtonsList = radioButtonsList;
	}
	
	//TODO figure out why this is flipped...
	public void setSpellTable(int index, int column, int row, String text){
		String[][] table = this.spells.get(index);
		table[row][column] = text;
//		this.spells.get(index)[row][column] = text;
//		System.out.println(this.spells.get(index)[row][column]);
		this.spells.put(index, table);
	}
	
	public String[][] getSpellTable(int index) {
		return this.spells.get(index);
	}
	
	public String getLevel(){
		return this.data.get(LEVEL);
	}
	
	public void setLevel(String level){
		String newLevel = this.lvlCalc(Integer.parseUnsignedInt(level));
		this.data.put(LEVEL, newLevel);
	}
	
	private String lvlCalc(int xpAmount){
		int lvl = 0;
		
		for(int i = 0; i <= this.LVLEXP.size() - 1; i++){
			if((i + 1) == 20){ // check the end
				lvl = (i + 1);
				return String.valueOf(lvl);
			}
			if(xpAmount >= this.LVLEXP.get(i) && xpAmount < this.LVLEXP.get(i + 1)){
				lvl = i + 1;
				return String.valueOf(lvl);
			}
		}
		return String.valueOf(lvl);
	}

	public void calcTotalPoints() {
		int total = 31;
		for(String ability: this.abilityScoreList){
			int score = Integer.parseInt(this.getData(ability));
			
			if(score >= 14){
				total -= (2*score -21);
			} else if(score >= 8){
				total -= (score - 8);
			} else if(score < 8){
				total += (8 - score);
			}
			System.out.println("total = " + total + " score = "+ score);
			
			
		}
		
		this.saveVariable(this.TOTALPOINTS, String.valueOf(total));
		
	}
	
}
