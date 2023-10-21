package baseball.domain;

public class HintResult {

	private static final String NOTHING = "낫싱";

	private final Hint hint;

	public HintResult(Hint hint) {
		this.hint = hint;
	}

	@Override
	public String toString() {
		int strike = hint.getStrikeCount();
		int ball = hint.getBallCount();
		if (strike > 0 && ball > 0) {
			return ball + "볼 " + strike + "스트라이크";
		}
		if (strike > 0 && hint.isBallCountZero()) {
			return strike + "스트라이크";
		}
		if (hint.isStrikeCountZero() && ball > 0) {
			return ball + "볼";
		}
		return NOTHING;
	}
}
