
public class Account {

	//atribut 
	private int balance = 1000; 
	
	
	
	public Account () {
		
	}
	
	public int getBalance () {
		return balance; 
	}
	
	public boolean deposit (int depositValue) {
		if (balance+depositValue < Integer.MAX_VALUE) {						//sørger for at balnacen aldrig bliver større end int max
			balance = balance + depositValue;
			return true; 
			}
		else 
			return false; 
	}
	
	public boolean withdraw (int withdrawValue) {
		if (balance - withdrawValue >= 0) {					 
			balance = balance - withdrawValue;
			return true; 
			}
		else 
			return false; 
	}
	
	
	
//	Benyttes ikke. 
//	public String toString () {
//		return "" + this.value;
//	}
}
