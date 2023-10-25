package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseBall {
	Scanner scanner = new Scanner(System.in);

	void startGame() {
		int gameFlag = 1;

		while (gameFlag == 1) {
			baseBallGame();

			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			gameFlag = scanner.nextInt();

			if (gameFlag == 2) {
				return;
			} else if (gameFlag != 1) {
				throw new IllegalArgumentException();
			}
		}
	}

	private void baseBallGame() {
		List<Integer> computer = createNum();
		int userInput;

		while (true) {
			int strike = 0;
			int ball = 0;

			userInput = scanner.nextInt();
			List<Integer> user = checkNum(userInput);

		}
	}

	private List<Integer> checkNum(int userInput) {
		List<Integer> user = new ArrayList<>();
		int userInputLength = (int)Math.log10(userInput) + 1;

		if (userInputLength != 3) {
			throw new IllegalArgumentException();
		}

		user = Stream.of(String.valueOf(userInput).split("")).mapToInt(Integer::parseInt).boxed().toList();

		for (int i = 0; i < 3; i++) {
			if (user.contains(user.get(i)))
				throw new IllegalArgumentException();
		}

		return user;
	}

	private List<Integer> createNum() {
		List<Integer> computer = new ArrayList<>();
		while (computer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}
		return computer;
	}
}
