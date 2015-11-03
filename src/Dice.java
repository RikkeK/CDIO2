public class Dice {

	int value;
	int sides;
	
	public Dice (int sides){
		this.sides = sides;
	}
	
	public void roll (){
		this.value = (int) (Math.random()*this.sides + 1);					//laver et tilfældigt tal mellem 1 og 6
	}
	
	public int getValue () {
		return this.value;
	}
	
//	Benyttes ikke. 
//	public String toString () {
//		return "" + this.value;
//	}
	
}
