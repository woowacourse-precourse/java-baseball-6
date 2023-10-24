package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
	private static List<Integer> randomNumber;
	private int ball, strike;

	BaseBallGame() {
		makeRandomNumber();
	}

	private static void makeRandomNumber() {
		randomNumber = new ArrayList<>();

		while (randomNumber.size() != 3) {
			int tmp = Randoms.pickNumberInRange(1, 9);
			if (!randomNumber.contains(tmp)) {
				randomNumber.add(tmp);
			}
		}
	}

	public List<Integer> getRandomNumber() {
		return randomNumber;
	}

	public void compare(int userNumber) {
		strike = 0;
		ball = 0;
		int[] numbers = new int[3];

		numbers[0] = userNumber / 100;
		numbers[1] = userNumber % 100 / 10;
		numbers[2] = userNumber % 100 % 10;

		for (int i = 0; i < 3; i++) {
			if (randomNumber.get(0) == numbers[i]) {
				if (i == 0) {
					strike++;
				} else {
					ball++;
				}
			}

			if (randomNumber.get(1) == numbers[i]) {
				if (i == 1) {
					strike++;
				} else {
					ball++;
				}
			}

			if (randomNumber.get(2) == numbers[i]) {
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
			System.out.print(strike + "스트라이크");
		}

		System.out.println();

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