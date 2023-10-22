package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
	Number computerNumber;
	Number inputNumber;

	public BaseBallGame() {
		start();
	}

	private void start() {
		this.computerNumber = new Number();
		System.out.println("숫자 야구 게임을 시작합니다.");

		guessTheNumbers();

		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

		askWantToRestart();
	}

	// 숫자 맞히는 과정
	private void guessTheNumbers() {
		String judgment = "";

		while (!judgment.equals("3스트라이크")) {
			System.out.print("숫자를 입력해주세요 : ");
			inputNumber = new Number(Console.readLine());

			judgment = judgeInputNumber(inputNumber.number);
			System.out.println(judgment);
		}
	}

	// 스트라이크, 볼 판정
	private String judgeInputNumber(String inputNumber) {
		int strike = 0;
		int ball = 0;
		for (int i = 0; i <= 2; i++) {
			if (inputNumber.charAt(i) == computerNumber.number.charAt(i)) {
				strike++;
				continue;
			}
			if (computerNumber.number.contains(Character.toString(inputNumber.charAt(i)))) {
				ball++;
			}
		}
		if (strike == 0 && ball == 0) {
			return "낫싱";
		}
		if (strike == 0) {
			return ball + "볼";
		}
		if (ball == 0) {
			return strike + "스트라이크";
		}
		return ball + "볼 " + strike + "스트라이크";
	}

	// 다시 시작할 것인지 물어본다.
	private void askWantToRestart() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

		String input = Console.readLine();

		if (input.equals("1")) {
			start();
			return;
		}
		if (input.equals("2")) {
			return;
		}
		throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 프로그램이 종료됩니다.");
	}

}
