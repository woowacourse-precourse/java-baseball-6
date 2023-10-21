package baseball.model;

import java.util.List;

public class Referee {

	private int calculateBall(List<Integer> computerNumber, List<Integer> playerNumber) {
		int ball = 0;

		for (int i = 0; i < computerNumber.size(); i++) {
			for (int j = 0; j < playerNumber.size(); j++) {
				if (i != j && computerNumber.get(i).equals(playerNumber.get(j))) {
					ball++;
				}
			}
		}

		return ball;
	}

	private int calculateStrikes(List<Integer> computerNumber, List<Integer> playerNumber) {
		int strike = 0;

		for (int i = 0; i < computerNumber.size(); i++) {
			if (computerNumber.get(i).equals(playerNumber.get(i))) {
				strike++;
			}
		}

		return strike;
	}
}
