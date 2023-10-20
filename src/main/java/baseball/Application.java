package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	private static String user = ""; // 사용자가 입력한 값을 받음.

	public static void runGame() {
		System.out.println("숫자 야구 게임을 시작합니다.");

		while (true) {
			play();

			if (quitOrContinue()) break;
		}
	}

	// 랜덤 3자리 번호 생성
	public static List<Integer> randomNumberInit() {
		List<Integer> computer = new ArrayList<>();

		while (computer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) computer.add(randomNumber);
		}

		return computer;
	}

	// 게임 시작
	public static void play() {
		List<Integer> computer = randomNumberInit();

		while (true) {
			System.out.print("숫자를 입력해주세요 : ");

			user = Console.readLine();

			// 잘못된 입력 처리
			if (user.length() != 3) throw new IllegalArgumentException();

			int[] scores = compare(computer, user);

			showResults(scores[0], scores[1]);

			if (isThreeStrike(scores[0])) break;
			
		}
	}

	/* *
	 * 컴퓨터와 사용자 숫자 비교 함수 
	 * return int[2] 
	 * 0 : strikeCount / 1 : ballCount
	 */
	public static int[] compare(List<Integer> computer, String user) {
		int strikeCount = 0;
		int ballCount = 0;

		for (int i = 0; i < computer.size(); i++) {
			int computerNumber = computer.get(i);
			for (int j = 0; j < user.length(); j++) {
				int userNumber = Integer.valueOf(user.charAt(j)) - '0';
				if (i == j && computerNumber == userNumber)
					strikeCount++;
				else if (computerNumber == userNumber)
					ballCount++;
			}
		}

		return new int[] { strikeCount, ballCount };
	}

	// 결과 보여주기
	public static void showResults(int strikeCount, int ballCount) {
		System.out.println(user);

		StringBuffer sb = new StringBuffer();
		if (ballCount != 0)
			sb.append(ballCount + "볼");
		if (ballCount != 0 && strikeCount != 0)
			sb.append(" ");
		if (strikeCount != 0)
			sb.append(strikeCount + "스트라이크");
		if (ballCount == 0 && strikeCount == 0)
			sb.append("낫싱");
		System.out.println(sb.toString());
	}

	// 종료 조건
	public static Boolean isThreeStrike(int strikeCount) {
		if (strikeCount == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return true;
		}
		return false;
	}

	// 재시작 종료 분기
	public static Boolean quitOrContinue() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

		user = Console.readLine();

		if(user.equals("1")) {
			return false;
		} else if (user.equals("2")) {
			System.out.println("게임을 종료합니다");
			return true;
		} else {
			// TODO : 예외 상황 논의.
			throw new IllegalArgumentException();
		}
	}

	public static void main(String[] args) {
		runGame();
	}
}
