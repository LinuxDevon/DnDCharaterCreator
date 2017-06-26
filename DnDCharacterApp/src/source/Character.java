package source;
import java.util.HashMap;

public class Character {
//	private String name;
	private int xp;
	
	private HashMap<String, Integer> abilityScores;
	private HashMap<String, Integer> modScores;
//	private String agentNum;
//	private String variant;
//	private String species;
//	private String rank;
//	private String charClass;
//	private String money;
	
	private HashMap<String, String> variableMap;
	
	public Character(String name, int amount, HashMap<String, Integer> abilityScores, String money, String charClass, String rank, String species, String variant, String agentNum){
//		this.name = name;
		this.xp = amount;
		this.abilityScores = abilityScores;
//		this.money = money;
//		this.charClass = charClass;
//		this.rank = rank;
//		this.species = species;
//		this.variant = variant;
//		this.agentNum = agentNum;
		
		this.variableMap = new HashMap<>();
		
		
		this.variableMap.put("name", name);
		this.variableMap.put("money", money);
		this.variableMap.put("class", charClass);
		this.variableMap.put("rank", rank);
		this.variableMap.put("species", species);
		this.variableMap.put("variant", variant);
		this.variableMap.put("agentNumber", agentNum);		
	}

	
	public String getAbilityScore(String name){
		return abilityScores.get(name).toString();
	}
	
	public String getName(){
		return this.variableMap.get("name");
	}
	
	public int getXP(){
		return this.xp;
	}
	
	public String getData(String variable){
		return this.variableMap.get(variable);
	}
	
	
}
