package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallGame {
	private static int randomNumber;
	BaseBallGame() {
		makeRandomNumber();
	}

	private static void makeRandomNumber() {
		int hundred, ten, one;
		randomNumber = Randoms.pickNumberInRange(123, 988);

		while (true) {
			hundred = randomNumber / 100;
			ten = randomNumber % 100 / 10;
			one = randomNumber % 100 % 10;

			if (hundred != ten && ten != one && one != hundred && hundred != 0 && ten != 0 && one != 0) {
				break;
			}

			randomNumber = Randoms.pickNumberInRange(1, 1000);
		}
	}

	public int getRandomNumber() {
		return randomNumber;
	}

	public void printFirst() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}
}
