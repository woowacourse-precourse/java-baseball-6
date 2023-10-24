package baseball.controller;

import baseball.service.ComputerBaseballService;

import java.util.List;

public class BaseballController {
	private ComputerBaseballService computerBaseballService = ComputerBaseballService.getInstance();

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
}


