package baseball.view;

import java.util.StringJoiner;

import baseball.util.message.ProgressMessage;

public class OutputView {

	public void printStartMessage() {
		System.out.println(ProgressMessage.START.getMessage());
	}

	public void printInputNumberMessage() {
		System.out.printf(ProgressMessage.INPUT_NUMBER.getMessage());
	}

	public void printClearMessage() {
		System.out.println(ProgressMessage.CLEAR.getMessage());
	}

	public void printAskContinueMessage() {
		System.out.println(ProgressMessage.ASK_CONTINUE.getMessage());
	}

	public void printResult(int ballCount, int StrikeCount) {
		StringJoiner joiner = new StringJoiner(" ");

		if (ballCount != 0) {
			String message = String.format(ProgressMessage.BALL.getMessage(), ballCount);
			joiner.add(message);
		}

		if (StrikeCount != 0) {
			String message = String.format(ProgressMessage.STRIKE.getMessage(), StrikeCount);
			joiner.add(message);
		}

		joiner.setEmptyValue(ProgressMessage.NOTHING.getMessage());

		System.out.println(joiner.toString().trim());
	}
}
