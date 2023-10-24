package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallGame {
	private static int randomNumber;
	private static int hundred, ten, one;
	private int ball, strike;

	BaseBallGame() {
		makeRandomNumber();
	}

	private static void makeRandomNumber() {
		randomNumber = Randoms.pickNumberInRange(123, 988);

		while (true) {
			hundred = randomNumber / 100;
			ten = randomNumber % 100 / 10;
			one = randomNumber % 100 % 10;

			if (hundred != ten && ten != one && one != hundred && hundred != 0 && ten != 0 && one != 0) {
				break;
			}

			randomNumber = Randoms.pickNumberInRange(123, 988);
		}
	}

	public int getRandomNumber() {
		return randomNumber;
	}

	public void printFirst() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	public void compare(int userNumber) {
		strike = 0;
		ball = 0;
		int[] numbers = new int[3];

		numbers[0] = userNumber / 100;
		numbers[1] = userNumber % 100 / 10;
		numbers[2] = userNumber % 100 % 10;

		for (int i = 0; i < 3; i++) {
			if (hundred == numbers[i]) {
				if (i == 0) {
					strike++;
				} else {
					ball++;
				}
			}

			if (ten == numbers[i]) {
				if (i == 1) {
					strike++;
				} else {
					ball++;
				}
			}

			if (one == numbers[i]) {
				if (i == 2) {
					strike++;
				} else {
					ball++;
				}
			}
		}

		printScore();
	}

	public void printScore() {
		if (strike == 0 && ball == 0) {
			System.out.println("낫싱");
			return;
		}
		if (ball > 0) {
			System.out.print(ball + "볼 ");
		}
		if (strike > 0) {
			System.out.println(strike + "스트라이크");
		}

		if (strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		}
	}

	private void printNumberQuestion() {
		System.out.print("숫자를 입력해주세요 : ");
	}

	public void printRestartQuestion() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	public void gameStart() {
		User user = new User();
		while (strike != 3) {
			printNumberQuestion();
			compare(user.input3DigitNumber());
		}
	}
}