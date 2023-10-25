package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseBall {
	Scanner scanner;

	public BaseBall() {
		this.scanner = new Scanner(System.in);
		startGame();
	}

	void startGame() {
		int gameFlag = 1;

		while (gameFlag == 1) {
			System.out.println("숫자 야구 게임을 시작합니다.");
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

			for (int i = 0; i < 3; i++) {
				if (computer.contains(user.get(i))) {
					ball++;
				}
				if (computer.get(i) == user.get(i)) {
					strike++;
					ball--;
				}
			}

			if (ball == 0 && strike == 0) {
				System.out.println("낫싱");
			} else if (ball == 0) {
				System.out.println(strike + "스트라이크");
			} else if (strike == 0) {
				System.out.println(ball + "볼");
			} else if (ball > 0 && strike > 0) {
				System.out.println(ball + "볼 " + strike + "스트라이크");
			}

			if (strike == 3) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				return;
			}

		}
	}

	private List<Integer> checkNum(int userInput) {
		List<Integer> user = new ArrayList<>();
		int userInputLength = (int)Math.log10(userInput) + 1;

		if (userInputLength != 3) {
			throw new IllegalArgumentException();
		}

		user = Stream.of(String.valueOf(userInput).split("")).mapToInt(Integer::parseInt).boxed().toList();

		if(user.size() != user.stream().distinct().count()){
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
