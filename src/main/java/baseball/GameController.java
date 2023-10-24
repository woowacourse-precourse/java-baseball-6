package baseball;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class GameController {

	public void run() {

		List<Integer> computerNumbers = new Computer().getComputerNumbers();

		boolean gameStatus = false;

		while (!gameStatus) {
			Game game = new Game(0, 0);
			game.calculateCount(new User().input(), computerNumbers);
			Result.printResult(game.getBall(), game.getStrike());
			if (game.getStrike() == 3) {
				gameStatus = true;
			}
		}
	}

	public boolean retryOrExit() {
		String input = userInput();
		if (input.equals("1")) {
			return true;
		}

		if (input.equals("2")) {
			return false;
		}

		throw new IllegalArgumentException("잘못된 값이 입력 되었습니다.");
	}

	private String userInput() {
		return Console.readLine();
	}

	public static void printStartMessage() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	public static void printInputMessage() {
		System.out.println("숫자를 입력해주세요 : ");
	}

}
