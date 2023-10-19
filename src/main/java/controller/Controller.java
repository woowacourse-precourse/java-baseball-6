package controller;

import views.InputView;

public class Controller {
	private final InputView inputView;
	public Controller() {
		this.inputView = new InputView();
	}

	public void playGame() {
		inputView.printIntro();
		int inputNumber = inputView.getInputNumber();
	}
}
