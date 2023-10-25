package baseball.game.setting;

import baseball.game.unit.Ball;
import baseball.game.unit.Catcher;
import baseball.game.unit.Pitcher;

public class Round {

	public static Round newRound() {
		return new Round();
	}

	private Round() {
	}

	public void progress(Pitcher pitcher, Catcher catcher) {
		pitcher.prepareRound();
		Ball ball = Ball.newBall();
		pitcher.throwBall(ball);
		catcher.catchBall(ball);
	}
}
