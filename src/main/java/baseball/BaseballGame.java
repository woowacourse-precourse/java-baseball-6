package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
	private static List<Integer> randomNumber;
	private int ball, strike;

	BaseballGame() {
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

	private int[] userNumberToArray(int userNumber) {
		int[] arr = new int[3];

		arr[0] = userNumber / 100;
		arr[1] = userNumber % 100 / 10;
		arr[2] = userNumber % 100 % 10;

		return arr;
	}

	private void compare(int i, int[] userNumbers) {
		if (randomNumber.contains(userNumbers[i])) {
			ball++;
			if (randomNumber.get(i) == userNumbers[i]) {
				strike++;
				ball--;
			}
		}
	}

	private void printScore() {
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

	public void gameStart(User user) throws IllegalArgumentException {
		while (strike != 3) {
			int[] userNumbers = userNumberToArray(user.input3DigitNumber());
			strike = 0;
			ball = 0;
			printNumberQuestion();
			for (int i = 0; i < userNumbers.length; i++) {
				compare(i, userNumbers);
			}
			printScore();
		}
	}
}