package baseball.game;

import static baseball.game.GameMessages.BALL;
import static baseball.game.GameMessages.BALL_STRIKE;
import static baseball.game.GameMessages.NOTHING;
import static baseball.game.GameMessages.STRIKE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameService {

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

	public List<Integer> generateRandomNumber() {
		List<Integer> numbers = new ArrayList<>();
		while (numbers.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!numbers.contains(randomNumber)) {
				numbers.add(randomNumber);
			}
		}

		return numbers;
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