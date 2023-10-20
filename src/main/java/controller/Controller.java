package controller;

import service.AnswerCreator;
import service.Game;
import views.InputView;

public class Controller {
	private final AnswerCreator answerCreator;
	private final InputView inputView;
	private final Game game;
	public Controller() {
		this.answerCreator = new AnswerCreator();
		this.inputView = new InputView();
		this.game = new Game();
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
	}
}
