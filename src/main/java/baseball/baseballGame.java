package baseball;

import static camp.nextstep.edu.missionutils.Console.*;

public class baseballGame {

	private static final String Continue = "1";
	private static final String Quit = "2";

	public baseballGame() {

	}

	public void play() {
		do {
			game();
		} while (regame());
	}

	public void game() {

		balls comBalls;
		result Result;
		comBalls = balls.makeRandomBall();
		gameStartMessage();
		do {
			gameInputMessage();
			Result = result.checkBalls(inputUserBalls(), comBalls);
			resultMessage(Result);
		} while (!Result.isAllCorrect());
		result.printEndMessage();
	}

	private balls inputUserBalls() {
		balls userBalls = null;
		while (userBalls == null) {
			String userInput = inputNumber();
			checkUserInputLength(userInput);
			try {
				userBalls = balls.addinputball(userInput);
			} catch (NumberFormatException e) {
				duplicationExceptionMessage();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return userBalls;
	}

	private static boolean regame() {
		String input = "";
		do {
			askRegame();
			input = inputNumber();
		} while ((invalidInput(input)));
		return input.equals(Continue);
	}

	private static boolean invalidInput(String input) {
		if (!input.equals(Continue) && !input.equals(Quit)) {
			askRegameExceptionMessage();
			return true;
		}
		return false;
	}

	private void gameStartMessage() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	private void gameInputMessage() {
		System.out.print("숫자를 입력해주세요 :");
	}

	private static String inputNumber() {
		return readLine();
	}

	private void checkUserInputLength(String str) {
		if (str.length() != balls.Ball_Count) {
			System.out.println("입력값의 길이가 잘못 되었습니다.");
		}
	}

	private static void askRegame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
	}

	private static void askRegameExceptionMessage() {
		System.out.println("1, 2만 입력 가능합니다. 다시 입력해주세요.");
	}

	private void duplicationExceptionMessage() {
		System.out.printf("%d개의 1~9 사이의 중복되지 않는 수만 입력할 수 있습니니다.%n", balls.Ball_Count);
	}

	private void resultMessage(result result) {
		System.out.println(result.getresultMessage());
	}
}
