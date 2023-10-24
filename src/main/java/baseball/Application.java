package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	static final int numberSize = 3;

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
			if (userNumbers.size() != numberSize) {
				throw new IllegalArgumentException();
			}

			List<Integer> calculatedValues = calculate(computerNumbers, userNumbers);
			StringBuilder result = getResult(calculatedValues);
			System.out.println(result.toString());

			/*컴퓨터 숫자 모두 맞추면 게임 종료*/
			if (calculatedValues.size() == numberSize && !calculatedValues.contains(1)) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다. 게임 종료");
				return; // 게임 종료
			}
		}
}

	/*컴퓨터 숫자 생성*/
	public static List<Integer> generateComputerNumbers() {
		List<Integer> computerNumbers = new ArrayList<>();
		while (computerNumbers.size() < numberSize) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computerNumbers.contains(randomNumber)) {
				computerNumbers.add(randomNumber);
			}
		}
		return computerNumbers;
	}

	/*사용자가 입력한 숫자*/
	public static List<Integer> readUserNumbers() {
		System.out.println("숫자를 입력해주세요 : ");
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
		for (int i = 0; i < numberSize; i++) {
			if (computerNumbers.get(i).equals(userNumbers.get(i))) {
				result.add(0); // 스트라이크
			} else if (computerNumbers.contains(userNumbers.get(i))) {
				result.add(1); // 볼
			}
		}
		return result;
	}

	/*스크라이크와 볼의 수 결과*/
	public static StringBuilder getResult(List<Integer> result) {
		int strikeCount = 0;
		int ballCount = 0;

		for (int value : result) {
			if (value == 0) {
				strikeCount++;
			} else if (value == 1) {
				ballCount++;
			}
		}

		StringBuilder gameResult = new StringBuilder();
		if (ballCount > 0) {
			gameResult.append(ballCount).append("볼");
		}
		if (strikeCount > 0) {
			if(ballCount > 0) {
				gameResult.append(" ");
			}
			gameResult.append(strikeCount).append("스트라이크");
		}
		if (strikeCount == 0 && ballCount == 0) {
			gameResult.append("낫싱");
		}
		return gameResult;
	}

	/*다시 시작, 종료 선택*/
	public static boolean RestartOrExit() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
		String restartValue = "1";
		String userInput = Console.readLine();
		Boolean result = userInput.equals(restartValue);
		if(!result) {
			System.out.println("게임 종료");
		}
		return result;
	}
}