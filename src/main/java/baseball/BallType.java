package baseball;

public enum BallType {
	STRIKE,
	BALL,
	NOTHING;

	public boolean isNotNothing() {
		return this != NOTHING;
	}

}
