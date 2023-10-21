package baseball;

import baseball.domain.BaseballNumber;
import baseball.service.BaseballCheckAnswerService;
import baseball.service.BaseballCreateService;
import baseball.service.BaseballGameFlowService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {

	private BaseballCreateService baseballCreateService;
	private BaseballCheckAnswerService baseballCheckAnswerService;
	private BaseballGameFlowService baseballGameFlowService;
	private InputView inputView;
	private OutputView outputView;

	public BaseballGame() {
		this.baseballCreateService = new BaseballCreateService();
		this.baseballCheckAnswerService = new BaseballCheckAnswerService();
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
			System.out.println(e.getMessage());
			throw e;
		}
	}

	public void init() {
		baseballGameFlowService.reset();
		outputView.printStartMessage();
	}

	public void progress() {
		BaseballNumber baseballNumber = baseballCreateService.createBaseballNumber();

		do {
			outputView.printInputNumberMessage();

			int inputDigit = inputView.inputNumber();
			int ballCount = baseballCheckAnswerService.getBallCount(baseballNumber, inputDigit);
			int StrikeCount = baseballCheckAnswerService.getStrikeCount(baseballNumber, inputDigit);

			outputView.printResult(ballCount, StrikeCount);
			baseballGameFlowService.checkClear(StrikeCount);
		} while (!baseballGameFlowService.isClear());

		outputView.printClearMessage();
	}

	public void retryOrExit() {
		outputView.printAskContinueMessage();
		int command = inputView.inputCommand();

		baseballGameFlowService.checkContinue(command);

		if (baseballGameFlowService.isContinue()) {
			play();
		}
	}
}
