package baseball;

import baseball.domain.controller.BaseballController;
import baseball.domain.service.BaseballService;

public class Application {

	public static void main(String[] args) {
		BaseballController baseballController = new BaseballController(new BaseballService());
		baseballController.run();
	}
}
