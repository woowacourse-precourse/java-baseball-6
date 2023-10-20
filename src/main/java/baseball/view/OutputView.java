package baseball.view;

import static baseball.model.Constant.MESSAGE_BALL;
import static baseball.model.Constant.MESSAGE_GAME_END;
import static baseball.model.Constant.MESSAGE_GAME_START;
import static baseball.model.Constant.MESSAGE_INPUT_NUMBER;
import static baseball.model.Constant.MESSAGE_NOTHING;
import static baseball.model.Constant.MESSAGE_STRIKE;

import java.text.MessageFormat;

public class OutputView {

	public void printGameStart() {
		System.out.println(MESSAGE_GAME_START.getMessage());
	}
	public void printGameEnd() {
		System.out.println(MESSAGE_GAME_END.getMessage());
	}
	public static void printInputNumber() {
		System.out.print(MESSAGE_INPUT_NUMBER.getMessage());
	}
	public void printResult(int strike, int ball) {
		if(strike == 0 && ball == 0){
			System.out.println(MESSAGE_NOTHING.getMessage());
			return;
		}
		if(strike > 0){
			System.out.print(
				MessageFormat.format("{0}{1}", strike, MESSAGE_STRIKE.getMessage()));
		}
		if(ball > 0){
			System.out.print(
				MessageFormat.format(" {0}{1}", ball, MESSAGE_BALL.getMessage()));
		}
		System.out.println();
	}

}
