package baseball.service;

import baseball.domain.Computer;
import baseball.view.FinishView;

public class DecideNextGameService {
	private static final int RETRY_NUM = 1;
	private static final int EXIT_NUM = 2;
	private boolean exit;
	private final FinishView finishView = new FinishView();

	public void checkExit(int retryNum, Computer computer) {
		if (retryNum == RETRY_NUM) {
			computer.setComputerNumber();
		}
		if (retryNum == EXIT_NUM) {
			exit = true;
		}
	}

	public void checkStatus(Computer computer) {
		checkExit(finishView.checkRetry(), computer);
	}

	public boolean isExit() {
		return exit;
	}
}