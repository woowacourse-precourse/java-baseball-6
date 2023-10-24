package baseball.domain;

import baseball.domain.balls.Balls;

public class Referee {

	public GameResult judge(final Balls computerBalls, final Balls playerBalls) {
		return computerBalls.compareBalls(playerBalls);
	}

}
