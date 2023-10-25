package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {

	public List<Integer> ComputerNum() {
		List<Integer> computer = new ArrayList<>();
		while (computer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}
		return computer;
	}

	public boolean Check(int play_num) {
		String PlayNum = String.valueOf(play_num);
		if (!PlayNum.matches("\\d{3}")) {
			throw new IllegalArgumentException();
		}
		char[] numCheck = PlayNum.toCharArray();
		if (numCheck[0] == numCheck[1] || numCheck[1] == numCheck[2] || numCheck[0] == numCheck[2]) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	public String Result(List<Integer> computer, List<Integer> player) {
		int strike = 0;
		int ball = 0;

		for (int i = 0; i < 3; i++) {
			if (computer.get(i).equals(player.get(i))) {
				strike++;
			} else if (computer.contains(player.get(i))) {
				ball++;
			}
		}

		if (strike == 3) {
			return "3스트라이크";
		} else if (strike == 0 && ball == 0) {
			return "낫싱";
		} else if (strike == 2 && ball == 0) {
			return "2스트라이크";
		} else if (strike == 1 && ball == 0) {
			return "1스트라이크";
		} else if (ball == 2 && strike == 0) {
			return "2볼";
		} else if (ball == 1 && strike == 0) {
			return "1볼";
		} else {
			return ball + "볼 " + strike + "스트라이크";
		}

	}
}