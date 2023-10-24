package baseball;

import baseball.domain.BaseballNumber;
import baseball.service.CountBallOrStrikeService;
import baseball.service.BaseballCreateService;
import baseball.service.BaseballGameFlowService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {

	private BaseballCreateService baseballCreateService;
	private CountBallOrStrikeService countBallOrStrikeService;
	private BaseballGameFlowService baseballGameFlowService;
	private InputView inputView;
	private OutputView outputView;

	public BaseballGame() {
		this.baseballCreateService = new BaseballCreateService();
		this.countBallOrStrikeService = new CountBallOrStrikeService();
		this.baseballGameFlowService = new BaseballGameFlowService();
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void play() {
		try {
			init();
			progress();
			retryOrExit();
		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			throw e;
		}
	}

	private void init() {
		baseballGameFlowService.reset();
		outputView.printStartMessage();
	}

	private void progress() {
		BaseballNumber baseballNumber = baseballCreateService.createBaseballNumber();

		do {
			outputView.printInputNumberMessage();

			int inputDigit = inputView.inputNumber();
			int ballCount = countBallOrStrikeService.getBallCount(baseballNumber, inputDigit);
			int StrikeCount = countBallOrStrikeService.getStrikeCount(baseballNumber, inputDigit);

			outputView.printResult(ballCount, StrikeCount);
			baseballGameFlowService.checkClear(StrikeCount);
		} while (!baseballGameFlowService.isClear());

		outputView.printClearMessage();
	}

	private void retryOrExit() {
		outputView.printAskContinueMessage();
		
		int command = inputView.inputCommand();

		baseballGameFlowService.checkContinue(command);

		if (baseballGameFlowService.isContinue()) {
			play();
		}
	}
}
