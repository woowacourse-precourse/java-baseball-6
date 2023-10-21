package baseball.controller;

import java.util.List;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballReferee;
import baseball.domain.Hint;
import baseball.domain.HintResult;
import baseball.domain.RandomNumberFactory;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

	private final RandomNumberFactory randomNumberFactory;
	private final BaseballReferee baseballReferee;

	public BaseballController(RandomNumberFactory randomNumberFactory, BaseballReferee baseballReferee) {
		this.randomNumberFactory = randomNumberFactory;
		this.baseballReferee = baseballReferee;
	}

	public void run() {
		OutputView.startMessage();
		start();
	}

	private void start() {
		BaseballNumber computerNumbers = randomNumberFactory.generate();
		while (true) {
			BaseballNumber playerNumbers = generatePlayerNumbers();
			Hint hint = baseballReferee.compare(computerNumbers, playerNumbers);
			HintResult hintResult = new HintResult(hint);
			OutputView.printHint(hintResult);
			if (hint.isThreeStrike()) {
				OutputView.printGameOver();
				return;
			}
		}
	}

	private BaseballNumber generatePlayerNumbers() {
		List<Integer> playerInputNumbers = InputView.readPlayerNumber();
		return new BaseballNumber(playerInputNumbers);
	}
}
