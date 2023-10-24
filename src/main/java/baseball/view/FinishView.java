package baseball.view;

import baseball.exception.InputRetryNumberException;
import camp.nextstep.edu.missionutils.Console;

public class FinishView {
	String continueNum;
	InputRetryNumberException retryException = new InputRetryNumberException();

	public int checkRetry() {
		continueNum = Console.readLine();
		retryException.checkException(continueNum);
		return Integer.valueOf(continueNum);
	}

}
