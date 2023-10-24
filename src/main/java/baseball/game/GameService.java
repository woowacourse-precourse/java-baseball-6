package baseball.game;

import baseball.util.ConsoleUtil;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameService {

	public String giveHint(List<Integer> player, List<Integer> answer) {
		int balls = countBall(player, answer);
		int strikes = countStrike(player, answer);

		return ConsoleUtil.hintFormatter(balls, strikes);
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