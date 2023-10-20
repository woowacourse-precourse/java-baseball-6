package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	private static String user = ""; // 사용자가 입력한 값을 받음.
	// 게임 시작
	public static void runGame() {
		System.out.println("숫자 야구 게임을 시작합니다.");

		while (true) {
			play();

			if (quitOrContinue()) break;
		}
	}

	// 게임 진행
	public static void play() {
		List<Integer> computer = randomNumberInit();

		while (true) {
			System.out.print("숫자를 입력해주세요 : ");

			user = Console.readLine();
			
			exceptionHandling();
			
			int[] scores = compare(computer);

			showResults(scores[0], scores[1]);

			if (isThreeStrike(scores[0])) break;
			
		}
	}
	
	public static void exceptionHandling() {
		int inputLength = user.length();
		// 잘못된 입력 처리
		if (inputLength != 3) throw new IllegalArgumentException();
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0 ; i < inputLength ; i++) {
			// 1~9 사이 수가 아니라면
			if(user.charAt(i) < '1' || user.charAt(i) > '9') {
				throw new IllegalArgumentException();
			}
			// 중복 검사를 위한 set 설정. 1~9 사이를 확인해서 integer를 보장 받을 수 있음
			set.add(user.charAt(i) - '0');
		}
		// 중복 검사
		if(set.size() != 3) throw new IllegalArgumentException();
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

	/* *
	 * 컴퓨터와 사용자 숫자 비교 함수 
	 * return int[2] 
	 * 0 : strikeCount / 1 : ballCount
	 */
	public static int[] compare(List<Integer> computer) {
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
			throw new IllegalArgumentException();
		}
	}

	public static void main(String[] args) {
		runGame();
	}
}
