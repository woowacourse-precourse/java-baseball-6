package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	List<Integer> playerNumber = new ArrayList<>();

	public void setPlayerNumber(String number) {
		playerNumber.clear();
		for (int i = 0; i < number.length(); i++) {
			char charDigit = number.charAt(i);
			int digit = Character.getNumericValue(charDigit);
			playerNumber.add(digit);
		}
	}
}
