public class DiceCup {

	//atri
	Dice dices [];
	
	public DiceCup () {
		int numberOfDices = 2;
		dices = new Dice [numberOfDices];
		for (int i = 0; i < numberOfDices; i++) {
			dices [i] = new Dice (6);
		}
	}
	
	public void roll () { 
		for (int i = 0; i < dices.length; i++) {
			dices[i].roll();
		}
	} 
	
	public int[] getDiceValue () {
		int[] diceValue = new int [dices.length];
		for (int i = 0; i < dices.length; i++) {
			diceValue[i] = dices[i].getValue();
		}
		return diceValue;
	}
	
	public int getDiceSum () {
		int diceSum = 0;
		for (int i = 0; i < dices.length; i++) {
			diceSum = diceSum + dices[i].getValue();
		}
		return diceSum;
	}
	
//	Benyttes ikke. 
//	public String toString () {
//		return "" + this.value;
//	}
	
	
	
}
