import static org.junit.Assert.*;

import org.junit.Test;

public class TestDice {

	@Test
	public void test() {
		Dice dice = new Dice (6);
		
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0;
		
		int numberOfDiceRolls = 1000;
		
		for (int i = 0; i < numberOfDiceRolls; i++) {
			dice.roll();
			int value = dice.getValue();
			
			switch (value) {
			case 1:
				count1++;
				break;
			case 2:
				count2++;
				break;
			case 3:
				count3++;
				break;
			case 4:
				count4++;
				break;
			case 5:
				count5++;
				break;
			case 6:
				count6++;
				break;
			}
			
		}

		int countSum = count1 + count2 + count3 + count4 + count5 + count6;
		int minCount = (countSum/6) - (countSum/100*10);							// 1/6 del + 10%  
		
		if (countSum != numberOfDiceRolls)
			fail();
		
		if ((count1 < minCount) || (count2 < minCount) || (count3 < minCount) || (count4 < minCount) || (count5 < minCount) || (count6 < minCount))
			fail();
	}

}
