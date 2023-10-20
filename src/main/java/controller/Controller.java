package controller;

import service.AnswerCreator;
import service.Game;
import views.InputView;
import views.OutputView;

public class Controller {
	private final AnswerCreator answerCreator;
	private final InputView inputView;
	private final Game game;
	private final OutputView outputView;
	public Controller() {
		this.answerCreator = new AnswerCreator();
		this.inputView = new InputView();
		this.outputView = new OutputView();
		this.game = new Game(outputView);
	}

	public void playGame() {
		inputView.printIntro();
		int answerNumber = answerCreator.createAnswer();
		while (true) {
			int inputNumber = inputView.getInputNumber();

			if (game.getGameResult(inputNumber, answerNumber)) {
				break;
			}
		}
		restartOrNot();
	}

	private void restartOrNot() {
		String opinion = inputView.inputOpinion();
		if (opinion.equals("1")) {
			playGame();
		}
		if (opinion.equals("2")) {
			outputView.gameOver();
		}
	}
}
