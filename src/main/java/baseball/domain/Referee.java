package baseball.domain;

public class Referee {

	public GameResult compare(final Balls computerBalls, final Balls playerBalls) {
		return computerBalls.compare(playerBalls);
	}

	public String notifyGameResult(GameResult gameResult) {
		return GameResultMessage.createMessage(gameResult);
	}

}
