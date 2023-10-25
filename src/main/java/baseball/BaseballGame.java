package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 숫자 야구 게임 객체의 클래스
 *
 * <p>게임 시작 시 랜덤 세자리 숫자 생성,
 * 게임 시작 및 사용자 숫자와 비교 및 결과 출력하는 함수 구현</p>
 */
public class BaseballGame {
	private static List<Integer> randomNumber;
	private int ball;
	private int strike;

	BaseballGame() {
		makeRandomNumber();
	}

	/** 랜덤 숫자 3자리 생성 */
	private static void makeRandomNumber() {
		randomNumber = new ArrayList<>();

		while (randomNumber.size() != 3) {
			int tmp = Randoms.pickNumberInRange(1, 9);
			if (!randomNumber.contains(tmp)) {
				randomNumber.add(tmp);
			}
		}
	}

	/** 3자리 랜덤 숫자를 반환 */
	public List<Integer> getRandomNumber() {
		return randomNumber;
	}

	/**
	 *  int형 3자리 사용자 숫자를 배열로 반환
	 * @param userNumber
	 * @return userNumber in array
	 */
	private int[] userNumberToArray(int userNumber) {
		int[] arr = new int[3];

		arr[0] = userNumber / 100;
		arr[1] = userNumber % 100 / 10;
		arr[2] = userNumber % 100 % 10;

		return arr;
	}

	/**
	 * 배열에 있는 3자리 사용자 숫자와 랜덤 숫자 비교 후 볼, 스트라이크 카운트
	 * @param i
	 * @param userNumbers
	 */
	private void compare(int i, int[] userNumbers) {
		if (randomNumber.contains(userNumbers[i])) {
			ball++;
			if (randomNumber.get(i) == userNumbers[i]) {
				strike++;
				ball--;
			}
		}
	}

	/** 게임의 볼과 스트라이크 횟수 출력 */
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

	/** 숫자 묻는 질문 출력 */
	private void printNumberQuestion() {
		System.out.print("숫자를 입력해주세요 : ");
	}

	/**
	 * 게임의 전체적인 함수를 실행하는 함수
	 * @param user
	 */
	public void gameStart(User user) {
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