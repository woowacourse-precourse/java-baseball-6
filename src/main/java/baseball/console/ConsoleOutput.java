package baseball.console;

import java.util.StringJoiner;

import baseball.console.constant.OutputConstant;
import baseball.dto.GameResult;
import baseball.service.constant.NumberConstant;

public class ConsoleOutput {
	public void printInit() {
		System.out.println(OutputConstant.GAME_INIT.getValue());
	}

	public void printReq() {
		System.out.print(OutputConstant.INPUT_REQ.getValue());
	}

	public void printResult(GameResult result) {
		StringJoiner message = new StringJoiner(" ");
		if (result.ballCount() != 0) {
			message.add(result.ballCount() + OutputConstant.BALL.getValue());
		}
		if (result.strikeCount() != 0) {
			message.add(result.strikeCount() + OutputConstant.STRIKE.getValue());
		}
		if (message.length() == 0) {
			message.add(OutputConstant.NONE.getValue());
		}
		System.out.println(message);
	}

	public void printEnd() {
		StringJoiner message = new StringJoiner("\n");
		message.add(NumberConstant.PICK_COUNT.getValue() + OutputConstant.STRIKE.getValue())
			.add(OutputConstant.SUCCESS.getValue())
			.add(OutputConstant.GAME_END.getValue());
		System.out.println(message);
	}
}
