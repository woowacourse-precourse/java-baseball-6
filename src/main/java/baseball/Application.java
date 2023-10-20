package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Application {
	public static void main(String[] args) {
		Game baseball = new Game();
		baseball.processGame();
	}
}

class Game {
	private static ArrayList<Integer> purposedNumber = new ArrayList<>();
	private static String userInput;

	Game() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	private ArrayList<Integer> getRandomNumber() {
		ArrayList<Integer> computer = new ArrayList<>();
		while (computer.size() < 3) {
			int randomNumber = pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}

		return computer;
	}

	private void checkUserInput(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}

		if (input.length() != 3) {
			throw new IllegalArgumentException();
		}
	}

	private int[] transformToArray(String input) {
		this.checkUserInput(input);
		return Stream.of(userInput.split("")).mapToInt(Integer::parseInt).toArray();
	}

	private void checkUserChoice() {
		String userChoice;
		userChoice = readLine();
		try {
			Integer.parseInt(userChoice);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}

		if (Integer.parseInt(userChoice) == 1) {
			this.processGame();
		} else if (Integer.parseInt(userChoice) == 2) {
			;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void processGame() {
		purposedNumber = this.getRandomNumber();
		int[] transformInput = new int[3];
		int[] purposedArray = purposedNumber.stream().mapToInt(Integer::intValue).toArray();

		System.out.println("주어진 숫자" + purposedNumber);
		while (!Arrays.equals(transformInput, purposedArray)) {
			int ballCount = 0;
			int strikeCount = 0;
			String alert = "";

			System.out.println("숫자를 입력해주세요. :");
			userInput = readLine();

			// 어레이로 변환
			transformInput = this.transformToArray(userInput);
			System.out.println("변환한 값" + Arrays.toString(transformInput));

			// 사용자가 입력 값과 주어진 값이 같은지 비
			for (int i = 0; i < purposedNumber.size(); i++) {
				if (purposedNumber.contains(transformInput[i])) { // 볼 조건
					ballCount++;
					if (purposedNumber.get(i) == transformInput[i]) { // 스트라이크 조건
						ballCount--;
						strikeCount++;
					}
				}
			}

			if (ballCount == 0 && strikeCount == 0) {
				alert = "낫싱";
			}

			if (ballCount > 0) {
				alert += ballCount + "볼 ";
			}

			if (strikeCount > 0) {
				alert += strikeCount + "스트라이크";
				if (strikeCount == 3) {
					System.out.println(alert);
					alert = "";
					System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
					System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
					this.checkUserChoice();
				}
			}

			System.out.println(alert);

		}

	}

}
