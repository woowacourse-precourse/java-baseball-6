package baseball;

import baseball.domain.controller.BaseballController;
import baseball.domain.service.BaseballService;
import baseball.domain.service.ClientService;

public class Application {

	public static void main(String[] args) {
		ClientService clientService = new ClientService();
		BaseballService baseballService = new BaseballService();
		BaseballController baseballController = new BaseballController(clientService, baseballService);
		baseballController.run();
	}
}
