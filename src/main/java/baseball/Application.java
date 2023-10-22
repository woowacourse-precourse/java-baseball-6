package baseball;

import baseball.controller.BaseballController;


public class Application {
	// 게임 시작
	public static void main(String[] args) {
		BaseballController baseballController = BaseballController.getInstance();
		baseballController.runGame(); 
	}
}