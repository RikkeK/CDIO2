public class Player {
	
	// atributter 
	String name;
	Account account = new Account(); 
	
	//construktor
	public Player (String name)
	{
		this.name = name;
	}
	
	public String getName ()
	{
		return this.name;
	}
	
	
	public boolean chanceBalance (int changeValue)
	{
		if (changeValue > 0) {
			return account.deposit(changeValue);
		}
		else
			return account.withdraw(-changeValue);
	}
	
	public int getBalance () {
		return account.getBalance();
	}
	
//	Benyttes ikke. 
//	public String toString () {
//		return "" + this.value;
//	}
	
	
	
	

}
