
public class Field {

	private String name;
	private String desciption;
	private int reward; 
	private boolean extraTurn; 
	
	public Field (String name , String desciption , int reward , boolean extraTurn) {
		this.name = name;
		this.desciption = desciption;
		this.reward = reward;
		this.extraTurn = extraTurn;
	}
	
	public void land (Player player) {
		player.chanceBalance(reward);
	}
	
	public boolean getIsExtraTurn () {										//skal addes til klasse, ellers er det ikke muligt at tjekke for ekstra tur 
		return this.extraTurn;
	}
	
	public String getDesciption () {											//skal addes til klasse, ellers er det ikke muligt at tjekke for ekstra tur 
		return this.desciption;
	}
	
	
//	Benyttes ikke. 
//	public String toString () {
//		return "" + this.value;
//	}
	
	
	
	
	
	
	
	
	
}
