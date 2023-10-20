package baseball.service;

import baseball.domain.command.Continue;

public class BaseballGameFlowService {

	private static final int CLEAR_COUNT = 3;

	private boolean isContinue;
	private boolean isClear;

	public BaseballGameFlowService() {
		this.isContinue = false;
		this.isClear = false;
	}

	public boolean isContinue() {
		return isContinue;
	}

	public boolean isClear() {
		return isClear;
	}

	public void reset() {
		this.isContinue = false;
		this.isClear = false;
	}

	public void checkContinue(int command) {
		if (Continue.checkContinue(command)) {
			doContinue();
		}
	}

	public void checkClear(int strikeCount) {
		if (strikeCount == CLEAR_COUNT) {
			doClear();
		}
	}

	private void doContinue() {
		this.isContinue = true;
	}

	private void doClear() {
		this.isClear = true;
	}

}
