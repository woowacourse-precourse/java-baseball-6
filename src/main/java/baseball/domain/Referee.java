package baseball.domain;

import baseball.domain.balls.Balls;

public class Referee {

	public GameResult compare(final Balls computerBalls, final Balls playerBalls) {
		return computerBalls.compare(playerBalls);
	}

	public String notifyGameResult(GameResult gameResult) {
		return GameResultMessage.createMessage(gameResult);
	}

}
