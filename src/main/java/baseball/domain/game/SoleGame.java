package baseball.domain.game;

import baseball.domain.player.defender.value.BallCount;
import baseball.domain.player.defender.value.Results;
import baseball.domain.player.defender.value.StrikeCount;
import baseball.domain.player.value.Balls;
import baseball.utils.input.Selector;
import baseball.utils.viewer.GuideMessage;
import baseball.utils.viewer.Viewer;

public abstract class SoleGame extends BasicGame {

	protected SoleGame(Selector selector, Viewer viewer) {
		super(selector, viewer);
	}

	@Override
	public void start() {
		initializeGame();
		execute();
		endOrRestart();
	}

	@Override
	protected void initializeGame() {
		initializeDefender();
	}

	/** 게임 시작시 Defender가 초기화 되어야 한다. */
	protected abstract void initializeDefender();

	@Override
	protected void execute() {
		while (true) {
			Viewer viewer = getViewer();
			viewer.print(GuideMessage.INPUT_NUMBER);
			Balls balls = getBalls();

			Results results = play(balls);

			StrikeCount strikeCount = results.getStrikeCount();
			BallCount ballCount = results.getBallCount();

			viewer.print(strikeCount, ballCount);

			if (strikeCount.isThreeStrike()) {
				break;
			}
		}
	}

	/** 게임 진행시 Attacker가 공을 선택해야 한다. */
	protected abstract Balls getBalls();

	/** 게임 진행시 Defender가 가지고 있는 공과 Attacker의 공을 비교해야 한다. */
	protected abstract Results play(Balls balls);
}
