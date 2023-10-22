package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {

	public List<Integer> playerNumber = new ArrayList<>();
	
	public void setPlayerNumber(String playerInput) {
		for (int i = 0; i < playerInput.length(); i++) {
			playerNumber.add(Character.getNumericValue((playerInput.charAt(i))));
		}
	}
}
