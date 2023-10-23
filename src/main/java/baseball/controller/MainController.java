package baseball.controller;

import baseball.view.Input;
import baseball.view.Output;

public class MainController {

	private static int menu;
	private static final int END_MENU = 2;

	private static BaseballController baseballController = new BaseballController();
	private static MainController mainController = new MainController();

	private MainController(){}

	public static MainController getMainController(){
		return mainController;
	}

	public void run(){
		Output.printStartMessage();
		do{
			baseballController.playGame();
			Output.printRestartMessage();
			menu = Input.getMenu();
		}while(menu!=END_MENU);
	}
}
