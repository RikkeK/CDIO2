import desktop_resources.GUI;
import java.util.Map;
import java.util.HashMap;

public class Game {

	// atributter

	private Player players[];
	private DiceCup diceCup;
	private Field fields[];
	
	// hashmap
	public static final Map<String, String> STRINGS = new HashMap<String, String>(); 
	
	public static void setUpStrings () {
		STRINGS.put("Tower", "Tower");							//change the last String for other language 
		STRINGS.put("Crater", "Crater");
		STRINGS.put("Palace Gates", "Palace Gates");
		STRINGS.put("Cold Desert", "Cold Desert");
		STRINGS.put("Walled city", "Walled city");
		STRINGS.put("Monastery", "Monastery");
		STRINGS.put("Black cave", "Black cave");
		STRINGS.put("Huts in the mountain", "Huts in the mountain");
		STRINGS.put("The Werewall (werewolf­wall)", "The Werewall (werewolf­wall)");
		STRINGS.put("The Pit", "The Pit");
		STRINGS.put("Goldmine", "Goldmine");
		
		STRINGS.put("This is the ", "This is the ");
		STRINGS.put(", your balance is chanced with: ", ", your balance is chanced with: ");
		STRINGS.put("Type the name of player ", "Type the name of player ");
		STRINGS.put(" click roll", " click roll");
		STRINGS.put("roll", "roll");
		STRINGS.put("Thanks for info", "Thanks for info");
		STRINGS.put(" has won!", " has won!");
		STRINGS.put("OK", "OK");
		
	}
	

	public Game() {
		// make fields
		fields = new Field[11];
		String[] fieldsNames = { STRINGS.get("Tower"), STRINGS.get("Crater"), STRINGS.get("Palace Gates"), STRINGS.get("Cold Desert"), STRINGS.get("Walled city"), STRINGS.get("Monastery"),
				STRINGS.get("Black cave"), STRINGS.get("Huts in the mountain"), STRINGS.get("The Werewall (werewolf­wall)"), STRINGS.get("The Pit"), STRINGS.get("Goldmine") };
		int[] fieldsRewards = { 250, -100, 100, -20, 180, 0, -70, 60, -80, -50, 650 };
		boolean[] fieldExtraTurn = { false, false, false, false, false, false, false, false, true, false, false };
		for (int i = 0; i < fields.length; i++) {
			fields[i] = new Field(fieldsNames[i],
					STRINGS.get("This is the ") + fieldsNames[i] + STRINGS.get(", your balance is chanced with: ") + fieldsRewards[i],
					fieldsRewards[i], fieldExtraTurn[i]);
		}

		// make a dicecup
		diceCup = new DiceCup();

		// make 2 players
		players = new Player[2];
		for (int i = 0; i < players.length; i++) {
			String typedName = GUI.getUserString(STRINGS.get("Type the name of player ") + (i + 1) + ": ");
			players[i] = new Player(typedName);
			GUI.addPlayer(players[i].name, players[i].getBalance());
		}

	}

	private boolean checkWinner() {
		for (int i = 0; i < players.length; i++) {
			if (players[i].getBalance() >= 3000) {
				return true;
			}
		}
		return false;
	}

	private void run() {
		while (!checkWinner()) {
			for (int i = 0; i < players.length; i++) {
				do {
					GUI.getUserButtonPressed(players[i].name + STRINGS.get(" click roll"), STRINGS.get("roll"));
					diceCup.roll();
					int[] dicesValue = diceCup.getDiceValue();
					GUI.setDice(dicesValue[0], dicesValue[1]);
					fields[diceCup.getDiceSum()-2].land(players[i]);
					GUI.setBalance(players[i].name, players[i].getBalance());
					GUI.getUserButtonPressed(players[i].name + ": " + fields[diceCup.getDiceSum()-2].getDesciption (),STRINGS.get("Thanks for info"));
					
				} while (fields[diceCup.getDiceSum()-2].getIsExtraTurn());
			}
			for (int i = 0; i < players.length; i++) {
				if (players[i].getBalance() > 3000)
					GUI.getUserButtonPressed(players[i].name + STRINGS.get(" has won!"), STRINGS.get("OK"));
			}

		}

	}

	public static void main(String[] args) {
		setUpStrings ();													// Create strings 
		Game game1 = new Game();
		game1.run();
	}
	
	
}
