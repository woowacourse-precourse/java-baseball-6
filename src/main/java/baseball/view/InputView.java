package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	private final String INPUT_GAME_RESTART_OR_FINISH_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	
	public String inputNumber() {
		System.out.print(INPUT_NUMBER_MESSAGE);
		return Console.readLine();
	}
	
	public int restartGameOrFinish() {
		System.out.println(INPUT_GAME_RESTART_OR_FINISH_MESSAGE);
		return Integer.parseInt(Console.readLine());
	}
}
