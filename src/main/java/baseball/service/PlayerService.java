package baseball.service;

import baseball.vo.enums.UserInterfaceMessage;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PlayerService {

	private PlayerService() {
	}

	private static class InnerOperatorService {
		private static final PlayerService instance = new PlayerService();
	}

	public static PlayerService getInstance() {
		return InnerOperatorService.instance;
	}

	public void printGameStartMessage() {
		System.out.println(UserInterfaceMessage.GAME_INFO.getValue());
	}

	public String requestInputGameNumber() {
		System.out.print(UserInterfaceMessage.REQUEST_INPUT.getValue());
		String inputGameNumber = readLine();
		System.out.println(inputGameNumber);
		return inputGameNumber;
	}
}
