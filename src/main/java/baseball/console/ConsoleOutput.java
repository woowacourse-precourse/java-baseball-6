package baseball.console;

import baseball.console.constant.OutputConstant;
import baseball.service.constant.NumberConstant;
import baseball.dto.GameResult;

public class ConsoleOutput {
	public void printInit() {
		System.out.println(OutputConstant.GAME_INIT.getValue());
	}

	public void printReq() {
		System.out.print(OutputConstant.INPUT_REQ.getValue());
	}

	public void printResult(GameResult result) {
		int ballCount = result.ballCount();
		int strikeCount = result.strikeCount();
		if (ballCount == 0 && strikeCount == 0) {
			System.out.println(OutputConstant.NONE.getValue());
		} else if (ballCount != 0 && strikeCount == 0) {
			System.out.println(ballCount + OutputConstant.BALL.getValue());
		} else if (ballCount == 0) {
			System.out.println(strikeCount + OutputConstant.STRIKE.getValue());
		} else {
			System.out.println(ballCount + OutputConstant.BALL.getValue()
				+ " " + strikeCount + OutputConstant.STRIKE.getValue());
		}
	}

	public void printEnd() {
		System.out.println(NumberConstant.PICK_COUNT.getValue() + OutputConstant.STRIKE.getValue());
		System.out.println(OutputConstant.SUCCESS.getValue());
		System.out.println(OutputConstant.GAME_END.getValue());
	}
}
