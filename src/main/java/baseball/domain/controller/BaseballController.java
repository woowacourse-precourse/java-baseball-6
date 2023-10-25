package baseball.domain.controller;

import baseball.domain.Client;
import baseball.domain.Computer;
import baseball.domain.service.BaseballService;
import baseball.domain.service.ClientService;
import baseball.global.constant.CommonStringType;
import baseball.global.constant.OutputType;
import baseball.global.utils.ConsoleUtil;
import baseball.global.utils.generator.InputNumberGenerator;
import baseball.global.utils.generator.RandomNumberGenerator;

public class BaseballController {

	private final ClientService clientService;
	private final BaseballService baseballService;

	public BaseballController(ClientService clientService, BaseballService baseballService) {
		this.clientService = clientService;
		this.baseballService = baseballService;
	}

	public void run() {
		ConsoleUtil.commonOutputLine(OutputType.GAME_INITIALIZE.getComment());
		do {
			Computer computer = new Computer(new RandomNumberGenerator());
			startGame(computer);
		} while (isRestart());
	}

	public void startGame(Computer computer) {
		Client client;
		do {
			ConsoleUtil.commonOutput(OutputType.INPUT_NUMBER.getComment());
			client = new Client(new InputNumberGenerator());
			baseballService.playRound(computer, client);
		} while (!client.gameEnd());
	}

	private boolean isRestart() {
		ConsoleUtil.commonOutputLine(OutputType.CHOOSE_RESTART.getComment());
		String restart = clientService.getRestartInput();
		return restart.equals(CommonStringType.RESTART.getContent());
	}
}
