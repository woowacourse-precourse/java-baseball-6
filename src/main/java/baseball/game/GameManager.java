package baseball.game;

import static baseball.game.GameMessages.BALL;
import static baseball.game.GameMessages.BALL_STRIKE;
import static baseball.game.GameMessages.NOTHING;
import static baseball.game.GameMessages.STRIKE;

import java.util.List;

public class GameManager {

	public String giveHint(List<Integer> player, List<Integer> answer) {
		int balls = countBall(player, answer);
		int strikes = countStrike(player, answer);

		if (balls > 0 && strikes > 0) {
			return BALL_STRIKE.getMessage().formatted(balls, strikes);
		} else if (balls > 0) {
			return BALL.getMessage().formatted(balls);
		} else if (strikes > 0) {
			return STRIKE.getMessage().formatted(strikes);
		} else {
			return NOTHING.getMessage();
		}
	}

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