package source;
import java.util.HashMap;

public class Character {
	private String name;
	private int xp;
	
	private HashMap<String, Integer> abilityScores;
	
	
	public Character(String name, int amount, HashMap<String, Integer> abilityScores){
		this.name = name;
		this.xp = amount;
		this.abilityScores = abilityScores;
		
	}
	
	public String getAbilityScore(String name){
		return abilityScores.get(name).toString();
	}
	
	public String getName(){
		return name;
	}
}
