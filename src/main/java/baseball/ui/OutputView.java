package baseball.ui;

import static baseball.global.constant.OutputMessage.*;

import baseball.global.constant.OutputMessage;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class OutputView {

	public void printGameStart() {
		println(GAME_START_MEESAGE);
	}

	public void printInputNumber() {
		print(INPUT_NUMBER_MESSAGE);
	}

	public void printGameEnd() {
		println(GAME_END_MESSAGE);
	}

	public void printGameRestart() {
		println(GAME_RESTART_MESSAGE);
	}

	private void println(String message) {
		System.out.println(message);
	}

	private void print(String message) {
		System.out.print(message);
	}

	public void printGameFinish() {
		println(THREE_STRIKE_MESSAGE);
		printGameEnd();
	}

	public void printGameResult(int ball, int strike) {
		println(String.format(GAME_RESULT_MESSAGE, ball, strike));
	}
}
