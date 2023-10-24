package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private Balls balls = new Balls();

	public Balls makeNumbers() {
		// 임의의 수 3개를 만든다.
		int count = 0;

		while (true) {
			if (count == 3) break;
			if (makeNumber()) count++;
		}

		return balls;
	}

	private boolean makeNumber() {
		try {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
				balls.add(randomNumber);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}
}
