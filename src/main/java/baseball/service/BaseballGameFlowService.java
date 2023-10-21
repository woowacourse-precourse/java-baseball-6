package baseball.service;

import baseball.domain.command.Continue;

public class BaseballGameFlowService {

	private static final int CLEAR_STRIKE_COUNT = 3;

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
		if (Continue.checkNew(command)) {
			doContinue();
		}
	}

	public void checkClear(int strikeCount) {
		if (isClearContition(strikeCount)) {
			doClear();
		}
	}
	
	private boolean isClearContition(int strikeCount) {
		return strikeCount == CLEAR_STRIKE_COUNT;
	}
	
	private void doContinue() {
		this.isContinue = true;
	}

	private void doClear() {
		this.isClear = true;
	}

}
