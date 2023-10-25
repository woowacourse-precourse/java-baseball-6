package baseball;

import static baseball.balls.*;

public class result {

	private static final String Strike = "스트라이크";
	private static final String Ball = "볼";
	private static final String Nothing = "낫싱";

	private final Integer strike;
	private final Integer ball;

	public result(Integer strike, Integer ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public static result checkBalls(balls gameBalls, balls userBalls) {
		int strike = 0;
		int ball = 0;

		for (int i = 0; i < Ball_Count; i++) {
			ball thisBall = gameBalls.get(i);

			if (thisBall.equals(userBalls.get(i))) {
				strike++;
				continue;
			}
			if (userBalls.contains(thisBall)) {
				ball++;
			}
		}

		return new result(strike, ball);
	}

	public String getresultMessage() {
		if (isNothing()) {
			return Nothing;
		}
		if (isStrike()) {
			return strike + Strike;
		}
		if (isBall()) {
			return ball + Ball;
		}
		return ball + Ball + " " + strike + Strike;
	}

	public boolean isAllStrikes() {
		if (strike == Ball_Count) {
			printEndMessage();
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		result result = (result) obj;
		return compareStrikeAndBall(result);
	}

	private boolean compareStrikeAndBall(result result) {
		return this.strike.equals(result.strike) && this.ball.equals(result.ball);
	}

	private boolean isNothing() {
		return strike == 0 && ball == 0;
	}

	private boolean isStrike() {
		return 0 < strike && ball == 0;
	}

	private boolean isBall() {
		return strike == 0 && 0 < ball;
	}

	private boolean isStrikeAndBall() {
		return 0 < strike && 0 < ball;
	}

	public boolean isAllCorrect() {
		return strike == Ball_Count;
	}

	public static void printEndMessage() {
		System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료%n", Ball_Count);
	}

}
