package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;

public class BaseBallGame {
	String computerNumber;

	public BaseBallGame() {
		start();
	}

	private void start() {
		this.computerNumber = generateRandomNumber();

		System.out.println("숫자 야구 게임을 시작합니다.");

		String judgment = "";

		while (!judgment.equals("3 스트라이크")) {
			System.out.print("숫자를 입력해주세요 : ");
			String myNumber = Console.readLine();
			validateMyNumber(myNumber);
			judgment = judgeMyNumber(myNumber);
			System.out.println(judgment);
		}

	}

	private String judgeMyNumber(String myNumber) {
		String ball = hasMyNumberBall(myNumber);
		String strike = hasMyNumberStrike(myNumber);
		if (ball.length() == 0 && strike.length() == 0) {
			return "낫싱";
		}
		return (ball + strike).trim();
	}

	private String hasMyNumberStrike(String myNumber) {
		return null;
	}

	private String hasMyNumberBall(String myNumber) {
		return null;
	}

	// 입력값 유효한지 검증
	private void validateMyNumber(String myNumber) {
		char[] arr = myNumber.toCharArray();
		if (arr.length != 3) {
			throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
		}
		if (arr[0] == arr[1] || arr[1] == arr[2] || arr[2] == arr[0]) {
			throw new IllegalArgumentException("서로 다른 임의의 수 3개를 입력해야 합니다.");
		}
		if (!('1' <= arr[0] && arr[0] <= '9') ||
				!('1' <= arr[1] && arr[1] <= '9') ||
				!('1' <= arr[2] && arr[2] <= '9')) {
			throw new IllegalArgumentException("숫자를 입력해야 합니다.");
		}
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
