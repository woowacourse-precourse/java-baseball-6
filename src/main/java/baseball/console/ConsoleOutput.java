package baseball.console;

import baseball.dto.BaseBallResult;

public class ConsoleOutput {
	public void printInit() {
		System.out.println(BaseBallConstant.GAME_INIT.getValue());
	}

	public void printReq() {
		System.out.print(BaseBallConstant.INPUT_REQ.getValue());
	}

	public void printResult(BaseBallResult result) {
		int ballCount = result.getBallCount();
		int strikeCount = result.getStrikeCount();
		if (ballCount == 0 && strikeCount == 0) {
			System.out.println(BaseBallConstant.NONE.getValue());
		} else if (ballCount != 0 && strikeCount == 0) {
			System.out.println(ballCount + BaseBallConstant.BALL.getValue());
		} else if (ballCount == 0) {
			System.out.println(strikeCount + BaseBallConstant.STRIKE.getValue());
		} else {
			System.out.println(ballCount + BaseBallConstant.BALL.getValue()
				+ " " + strikeCount + BaseBallConstant.STRIKE.getValue());
		}
	}

	public void printEnd() {
		System.out.println(NumberConstant.PICK_COUNT.getValue() + BaseBallConstant.STRIKE.getValue());
		System.out.println(BaseBallConstant.SUCCESS.getValue());
		System.out.println(BaseBallConstant.GAME_END.getValue());
	}
}
