package source;
import java.util.HashMap;

public class Character {
//	private String name;
	private int xp;
	
	private HashMap<String, String> data;
//	private HashMap<String, Integer> modScores;
//	private String agentNum;
//	private String variant;
//	private String species;
//	private String rank;
//	private String charClass;
//	private String money;
	
//	private HashMap<String, String> variableMap;
	
	// old constructor incase the new one didn't work
//	public Character(String name, int amount, HashMap<String, String> data, String money, String charClass, String rank, String species, String variant, String agentNum){
////		this.name = name;
//		this.xp = amount;
//		this.data = data;
////		this.money = money;
////		this.charClass = charClass;
////		this.rank = rank;
////		this.species = species;
////		this.variant = variant;
////		this.agentNum = agentNum;
//		
//		this.variableMap = new HashMap<>();
//		
////		for(String key: abilityScores.keySet()){
////			this.variableMap.put(key, abilityScores.get(key));
////			System.out.println(this.variableMap);
////		}
//		this.variableMap.put("name", name);
//		this.variableMap.put("money", money);
//		this.variableMap.put("class", charClass);
//		this.variableMap.put("rank", rank);
//		this.variableMap.put("species", species);
//		this.variableMap.put("variant", variant);
//		this.variableMap.put("agentNumber", agentNum);		
//	}

	
	public Character(Integer xp, HashMap<String, String> data) {
		this.xp = xp;
		this.data = data;
	}


	public String getAbilityScore(String name){
		return this.data.get(name);
	}
	
	public String getName(){
		return this.data.get("name");
	}
	
	public int getXP(){
		return this.xp;
	}
	
	public String getData(String variable){
		return this.data.get(variable);
	}
	
	public String modLabelCreator(String key){
//		this.player.getData(variable)": Strength"
		System.out.println(getData(key) + ": " + key);
		return getData(key + "Mod") + " : " + key;
	}
	
}
