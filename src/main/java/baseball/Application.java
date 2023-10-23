package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

	public static void main(String[] args) {
		startGame();
	}

	public static void startGame() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		do {
			playGame();
		} while (RestartOrExit());
	}

	public static void playGame() {
		List<Integer> computerNumbers = generateComputerNumbers();

		//컴퓨터 숫자 맞출 때까지 무한 루프
		while (true) {
			List<Integer> userNumbers = readUserNumbers();
			List<Integer> result = calculate(computerNumbers, userNumbers);
			printResult(result);

			/*컴퓨터 숫자 모두 맞추면 게임 종료*/
			if (result.size() == 3 && !result.contains(1)) {
				return; // 게임 종료
			}
		}
}

	/*컴퓨터 숫자 생성*/
	public static List<Integer> generateComputerNumbers() {
		List<Integer> computerNumbers = new ArrayList<>();
		while (computerNumbers.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computerNumbers.contains(randomNumber)) {
				computerNumbers.add(randomNumber);
			}
		}
		return computerNumbers;
	}

	/*사용자가 입력한 숫자*/
	public static List<Integer> readUserNumbers() {
		System.out.print("숫자를 입력해주세요 : ");
		String userInput = Console.readLine();
		List<Integer> userNumbers = new ArrayList<>(); //userNumbers 리스트 생성

		for (int i = 0; i < userInput.length(); i++) {
			int digit = Character.getNumericValue(userInput.charAt(i)); //숫자로 변환
			userNumbers.add(digit);
		}
		return userNumbers;
	}

	/*컴퓨터 숫자와 사용자 숫자 비교*/
	public static List<Integer> calculate(List<Integer> computerNumbers, List<Integer> userNumbers) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if (computerNumbers.get(i).equals(userNumbers.get(i))) {
				result.add(0); // 스트라이크
			} else if (computerNumbers.contains(userNumbers.get(i))) {
				result.add(1); // 볼
			}
		}
		return result;
	}

	/*스크라이크와 볼의 수 결과*/
	public static void printResult(List<Integer> result) {
		int strikes = 0;
		int balls = 0;

		for (int value : result) {
			if (value == 0) {
				strikes++;
			} else if (value == 1) {
				balls++;
			}
		}

		if (strikes > 0) {
			System.out.print(strikes + "스트라이크 ");
		}
		if (balls > 0) {
			System.out.print(balls + "볼");
		}
		if (strikes == 0 && balls == 0) {
			System.out.print("낫싱");
		}
		System.out.println();
	}

	/*다시 시작, 종료 선택*/
	public static boolean RestartOrExit() {
		System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
		String userInput = Console.readLine();
		return "1".equals(userInput);
	}
}