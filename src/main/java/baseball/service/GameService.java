package baseball.service;

import baseball.domain.Computer;
import baseball.domain.GameResult;
import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.domain.balls.Balls;

public class GameService {

	public Computer createComputer() {
		return new Computer();
	}

	public GameResult requestJudgment(final Computer computer, final Player player) {
		final Referee referee = new Referee();
		final Balls computerBalls = computer.getBalls();
		final Balls playerBalls = player.getBalls();

		return referee.judge(computerBalls, playerBalls);
	}

	public boolean isEnded(final GameResult gameResult) {
		return gameResult.isEnded();
	}

	public boolean isReplay(final String replayCommandInput) {
		GameCommand.validate(replayCommandInput);
		return GameCommand.isReplayCommand(replayCommandInput);
	}

}
