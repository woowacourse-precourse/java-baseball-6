package controller;

import service.AnswerCreator;
import views.InputView;

public class Controller {
	private final AnswerCreator answerCreator;
	private final InputView inputView;
	public Controller() {
		this.answerCreator = new AnswerCreator();
		this.inputView = new InputView();
	}

	public void playGame() {
		inputView.printIntro();
		int answerNumber = answerCreator.createAnswer();
		int inputNumber = inputView.getInputNumber();
	}
}
