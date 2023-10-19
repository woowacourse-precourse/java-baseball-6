package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
	String computerNumber;

	public BaseBallGame() {
		start();
	}

	private void start() {
		this.computerNumber = generateRandomNumber();
	}

	// 1에서 9까지 서로 다른 임의의 수 3개를 선택하여 문자열로 출력합니다.
	private String generateRandomNumber() {
		String str = "";
		str += Randoms.pickNumberInRange(1, 9);
		while (str.length() != 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!str.contains(String.valueOf(randomNumber))) {
				str += randomNumber;
			}
		}
		return str;
	}

}
