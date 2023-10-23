package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {

	public List<Integer> number = new ArrayList<>();
	
	public void setNumber(String playerInput) {
		for (int i = 0; i < playerInput.length(); i++) {
			number.add(Character.getNumericValue((playerInput.charAt(i))));
		}
	}

	public List<Integer> getNumber() {
		return this.number;
	}
}
