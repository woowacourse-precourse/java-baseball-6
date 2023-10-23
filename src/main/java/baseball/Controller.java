package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
	private final Computer computer = new Computer();
	private final Player player = new Player();
	private Result result;

	private void initGame() {
		computer.init();
	}

	public void run() {
		System.out.println("숫자 야구 게임을 시작합니다.");

		initGame();

		do {
			System.out.print("숫자를 입력해주세요 : ");

			String numbers = Console.readLine();
			Validator.validateNumbers(numbers);

			player.init(numbers);

			result = checkResult();

			result.printResult();
		} while (!result.isAnswer() || askRestart());
	}

	private Result checkResult() {
		int ball = 0;
		int strike = 0;
		boolean isAnswer = false;

		for (int i = 0; i < Constants.NUMBER_LENGTH; i++) {
			if (computer.numbers.get(i).equals(player.numbers.get(i))) {
				strike++;
				continue;
			}
			if (computer.numbers.contains(player.numbers.get(i))) {
				ball++;
			}
		}

		if (strike == 3) {
			isAnswer = true;
		}

		return new Result(ball, strike, isAnswer);
	}

	private boolean askRestart() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

		String isRestart = Console.readLine();
		Validator.validateIsRestart(isRestart);

		if (isRestart.equals("1")) {
			initGame();

			return true;
		} else {
			return false;
		}
	}
}