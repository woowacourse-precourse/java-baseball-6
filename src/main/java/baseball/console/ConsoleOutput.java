package baseball.console;

import baseball.constant.GameConstant;
import baseball.constant.NumberConstant;
import baseball.dto.BaseBallResult;

public class ConsoleOutput {
	public void printInit() {
		System.out.println(GameConstant.GAME_INIT.getValue());
	}

	public void printReq() {
		System.out.print(GameConstant.INPUT_REQ.getValue());
	}

	public void printResult(BaseBallResult result) {
		int ballCount = result.ballCount();
		int strikeCount = result.strikeCount();
		if (ballCount == 0 && strikeCount == 0) {
			System.out.println(GameConstant.NONE.getValue());
		} else if (ballCount != 0 && strikeCount == 0) {
			System.out.println(ballCount + GameConstant.BALL.getValue());
		} else if (ballCount == 0) {
			System.out.println(strikeCount + GameConstant.STRIKE.getValue());
		} else {
			System.out.println(ballCount + GameConstant.BALL.getValue()
				+ " " + strikeCount + GameConstant.STRIKE.getValue());
		}
	}

	public void printEnd() {
		System.out.println(NumberConstant.PICK_COUNT.getValue() + GameConstant.STRIKE.getValue());
		System.out.println(GameConstant.SUCCESS.getValue());
		System.out.println(GameConstant.GAME_END.getValue());
	}
}
