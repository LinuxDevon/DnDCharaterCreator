package souce;

public class Character {
	String name;
	int xp;
	
	public Character(String name, int amount){
		this.name = name;
		this.xp = amount;
	}
	
	public String getName(){
		return name;
	}
}
