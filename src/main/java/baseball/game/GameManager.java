package baseball.game;

import java.util.List;

public class GameManager {

	public int countBall(List<Integer> player, List<Integer> answer) {
		int ball = 0;
		for (int i = 0; i < player.size(); i++) {
			if (answer.contains(player.get(i)) && !answer.get(i).equals(player.get(i))) {
				ball++;
			}
		}

		return ball;
	}

	public int countStrike(List<Integer> player, List<Integer> answer) {
		int strike = 0;
		for (int i = 0; i < player.size(); i++) {
			if (player.get(i).equals(answer.get(i))) {
				strike++;
			}
		}

		return strike;
	}
}