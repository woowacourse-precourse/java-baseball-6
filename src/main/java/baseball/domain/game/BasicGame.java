package baseball.domain.game;

import baseball.support.EndOptions;
import baseball.utils.input.Selector;
import baseball.utils.viewer.GuideMessage;
import baseball.utils.viewer.Viewer;

public abstract class BasicGame implements Game {

	private final Selector selector;
	private final Viewer viewer;

	protected BasicGame(Selector selector, Viewer viewer) {
		this.selector = selector;
		this.viewer = viewer;
		viewer.print(GuideMessage.START);
	}

	/** 게임을 설정을 초기화합니다. */
	protected abstract void initializeGame();

	/** 게임을 진행합니다. */
	protected abstract void execute();

	/** 게임을 종료하거나 재시작합니다. */
	protected void endOrRestart() {
		viewer.print(GuideMessage.RESTART);

		EndOptions endOptions = EndOptions.valueOf(selector.selectEndOption());
		if (EndOptions.END == endOptions) {
			viewer.print(GuideMessage.END);
			return;
		}

		start();
	}

	protected Selector getSelector() {
		return selector;
	}

	protected Viewer getViewer() {
		return viewer;
	}

	protected Long getSelectorSize() {
		return selector.getSelectNumbersSize();
	}
}
