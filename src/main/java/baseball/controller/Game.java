package baseball.controller;

import baseball.domain.Numbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {
	private static final int THREE_STRIKE = 3;
	private final InputView inputView;
	private final OutputView outputView;
	private final Numbers computer = new Numbers();


	public Game(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void playOnce() {
		outputView.printGameStartMessage();
		do {
			Numbers playerNumbers = new Numbers(inputView.createPlayerNumber());
			int strike = computer.countStrike(playerNumbers);
			int ball = computer.countBall(playerNumbers);
			outputView.printResult(strike, ball);
			if (strike == THREE_STRIKE) {
				break;
			}
		} while (true);
		outputView.printFinishMessage();
	}
}
