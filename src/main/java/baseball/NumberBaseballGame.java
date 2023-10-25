package baseball;

import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballGame {
	// 컴퓨터가 생성할 숫자의 자릿수
	private static final int SIZE = 3;
	private final Computer computer;

	NumberBaseballGame() {
		this.computer = new Computer(SIZE);
	}

	// 게임 종료 선택 입력이 유효한지 확인하는 메서드.
	private boolean isLegalChoice(String choice) {
		if (choice.equals("1")) {
			return true;
		} else if (choice.equals("2")) {
			return true;
		}
		// 1, 2 이외의 값을 입력한 경우
		return false;
	}

	// 게임을 계속 이어서 할 지 종료할 지 선택하는 메서드
	private boolean chooseContinueGame(boolean isCorrect) {
		// 답이 틀린 경우 입력을 계속 받아야 합니다.
		if (!isCorrect) {
			return true;
		}
		// 답이 맞은 경우 사용자에게 입력을 받아 게임을 계속할 지 중단할 지 결정합니다.
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String choice = Console.readLine();
		// 입력이 올바르지 않은 경우
		if (!isLegalChoice(choice)) {
			throw new IllegalArgumentException("1또는 2를 입력하세요.");
		}
		// 입력이 올바른 경우

		// 게임을 계속하는 경우, 컴퓨터가 임의의 숫자의 배열을 다시 생성합니다.
		if (choice.equals("1")) {
			computer.selectGameNumbers();
			return true;
		}
		// 게임을 종료하는 경우
		return false;
	}

	// 게임을 시작하는 메서드.
	public void playGame() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		boolean continueGame;
		do {
			// 3자리 수를 입력 받음
			System.out.print("숫자를 입력해주세요 : ");
			String input = Console.readLine();
			boolean isCorrect = computer.gradeInput(input);
			continueGame = chooseContinueGame(isCorrect);
		} while (continueGame);
	}
}
