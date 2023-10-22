package baseball;

import java.util.List;

public class CompareNumber {

	public int strike;
	public int ball;
	
	public CompareNumber() {
		this.strike = 0;
		this.ball = 0;
	}
	
	public void compare(List<Integer> computerNumber, List<Integer> playerNumber) {
		for (int i = 0; i < computerNumber.size(); i++) {
			if (computerNumber.get(i) == playerNumber.get(i)) {
				this.strike ++;
				continue;
			}
			if (computerNumber.contains(playerNumber.get(i))) {
				this.ball ++;
			}
		}
	}
}
