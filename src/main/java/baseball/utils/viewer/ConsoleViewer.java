package baseball.utils.viewer;

import static baseball.utils.viewer.GuideMessage.STRIKE_OUT;

import baseball.domain.player.defender.value.BallCount;
import baseball.domain.player.defender.value.StrikeCount;

public class ConsoleViewer implements Viewer {

	private static final String SPACE = " ";
	private static final String CRLF = "\n";

	private static final String STRIKE = "스트라이크";
	private static final String BALL = "볼";
	private static final String NOTHING = "낫싱";

	@Override
	public void print(String message) {
		System.out.println(message);
	}

	@Override
	public void print(StrikeCount strikeCount, BallCount ballCount) {
		if (strikeCount.isEmpty() && ballCount.isEmpty()) {
			this.print(NOTHING);
			return;
		}

		StringBuilder source = getMessage(strikeCount, ballCount);

		this.print(source.toString());
	}

	private StringBuilder getMessage(StrikeCount strikeCount, BallCount ballCount) {
		StringBuilder source = new StringBuilder();
		appendBall(source, ballCount);
		appendSpace(source, strikeCount, ballCount);
		appendStrike(source, strikeCount);
		return source;
	}

	private void appendBall(StringBuilder source, BallCount ballCount) {
		if (ballCount.getCount() > 0) {
			source.append(ballCount.getCount());
			source.append(BALL);
		}
	}

	private void appendSpace(StringBuilder source, StrikeCount strikeCount, BallCount ballCount) {
		if (ballCount.getCount() > 0 && strikeCount.getCount() > 0) {
			source.append(SPACE);
		}
	}

	private void appendStrike(StringBuilder source, StrikeCount strikeCount) {
		if (strikeCount.getCount() > 0) {
			source.append(strikeCount.getCount());
			source.append(STRIKE);
			appendStrikeOut(source, strikeCount);
		}
	}

	private void appendStrikeOut(StringBuilder source, StrikeCount strikeCount) {
		if (strikeCount.isThreeStrike()) {
			source.append(CRLF);
			source.append(STRIKE_OUT.getMessage());
		}
	}

	@Override
	public void print(GuideMessage message) {
		print(message.getMessage());
	}
}
