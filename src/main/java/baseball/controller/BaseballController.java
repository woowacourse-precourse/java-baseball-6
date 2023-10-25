package baseball.controller;

import baseball.service.ComputerBaseballService;
import baseball.service.OperatorService;
import baseball.service.PlayerService;
import baseball.vo.enums.ValidationMessage;

import java.util.List;

public class BaseballController {
	private ComputerBaseballService computerBaseballService = ComputerBaseballService.getInstance();
	private OperatorService operatorService = OperatorService.getInstance();
	private PlayerService playerService = PlayerService.getInstance();

	private BaseballController() {}

	public List<Integer> getComputerBaseballGameNumberList() {
		return computerBaseballService.getComputerBaseballGameNumberList();
	}

	private static class BaseballControllerHolder {
		private static final BaseballController BASEBALL_CONTROLLER = new BaseballController();
	}

	public static BaseballController getInstance() {
		return BaseballControllerHolder.BASEBALL_CONTROLLER;
	}

	public void createNewBaseballGameNumberList() {
		computerBaseballService.createNewBaseballGameNumberList();
	}

	public void gameStart() {
		operatorService.printGameStartMessage();
		String inputGameNumber;
		do {
			inputGameNumber = playerService.requestInputGameNumber();
			try {
				operatorService.validateGameNumber(inputGameNumber);
			} catch (IllegalArgumentException exception) {
				System.out.println(ValidationMessage.STOP_GAME.getValue());
				throw new IllegalArgumentException(); // 예외를 잡지말고 다시 던짐
			}
			inputGameNumber = operatorService.operateGame(getComputerBaseballGameNumberList(), inputGameNumber);
		} while (!inputGameNumber.equals("2"));
	}
}


