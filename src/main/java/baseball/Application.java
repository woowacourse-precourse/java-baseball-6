package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	private final static int MAX_DIGIT = 3;
	private final static int STRIKE_COUNT_INDEX = 0;
	private final static int BALL_COUNT_INDEX = 1;

	private static String user = ""; // 사용자가 입력한 값을 받음.
	// 0 : strikeCount / 1 : ballCount
	private static int[] scores = new int[2];

	// 게임 시작
	public static void runGame() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		while (true) {
			play();
			if (quit())
				break;
		}
	}

	// 게임 진행
	public static void play() {
		List<Integer> computer = randomNumberGenerate();

		while (true) {
			System.out.print("숫자를 입력해주세요 : ");
			user = Console.readLine();
			exceptionHandling();
			compare(computer);
			showResults();
			if (threeStrike())
				break;
		}
	}

	// 예외 처리
	public static void exceptionHandling() {
		int inputLength = user.length();

		Set<Character> set = new HashSet<>();
		for (int i = 0; i < inputLength; i++) {
			char ch = user.charAt(i);
			// 1~9 사이 수가 아니라면
			if (ch < '1' || ch > '9') {
				throw new IllegalArgumentException();
			}
			set.add(ch);
		}
		// 길이 조건 3자리 및 중복 검사
		if (inputLength != MAX_DIGIT || set.size() != MAX_DIGIT)
			throw new IllegalArgumentException();
	}

	// 랜덤 3자리 번호 생성
	public static List<Integer> randomNumberGenerate() {
		List<Integer> computer = new ArrayList<>();

		while (computer.size() < MAX_DIGIT) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber))
				computer.add(randomNumber);
		}

		return computer;
	}

	// 컴퓨터와 사용자 숫자 비교 함수
	public static void compare(List<Integer> computer) {
		int strikeCount = 0;
		int ballCount = 0;

		for (int i = 0; i < computer.size(); i++) {
			int computerNumber = computer.get(i);
			int userNumber = Integer.valueOf(user.charAt(i)) - '0';

			if (computerNumber == userNumber)
				strikeCount++;
			else if (computer.contains(userNumber))
				ballCount++;
		}

		scores[STRIKE_COUNT_INDEX] = strikeCount;
		scores[BALL_COUNT_INDEX] = ballCount;
	}

	// 결과 보여주기
	public static void showResults() {
		int strikeCount = scores[STRIKE_COUNT_INDEX];
		int ballCount = scores[BALL_COUNT_INDEX];

		System.out.println(user);

		StringBuffer sb = new StringBuffer();
		if (ballCount == 0 && strikeCount == 0) {
			sb.append("낫싱");
		} else {
			if (ballCount != 0) {
				sb.append(ballCount + "볼 ");
			}
			if (strikeCount != 0)
				sb.append(strikeCount + "스트라이크");
		}

		System.out.println(sb.toString().trim());
	}

	// 종료 조건
	public static Boolean threeStrike() {
		int strikeCount = scores[STRIKE_COUNT_INDEX];

		if (strikeCount == MAX_DIGIT) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return true;
		}
		return false;
	}

	// 재시작 종료 분기
	public static Boolean quit() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

		user = Console.readLine();

		if (user.equals("1")) {
			return false;
		} else if (user.equals("2")) {
			System.out.println("게임을 종료합니다");
			return true;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public static void main(String[] args) {
		runGame();
	}
}
