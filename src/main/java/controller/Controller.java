package controller;

import service.AnswerCreator;
import service.Game;
import service.Validator;
import views.InputView;
import views.OutputView;

public class Controller {
	private final Validator validator;
	private final AnswerCreator answerCreator;
	private final InputView inputView;
	private final Game game;
	private final OutputView outputView;
	public Controller() {
		this.validator = new Validator();
		this.answerCreator = new AnswerCreator(validator);
		this.inputView = new InputView(validator);
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
