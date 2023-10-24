package baseball.domain.service;

import baseball.domain.model.Computer;
import baseball.domain.model.Game;
import baseball.domain.model.User;
import baseball.global.util.PrintUtil;
import baseball.global.util.ValidateInputUtil;
import baseball.global.util.enums.GameRestartEnum;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameService {

	private User user;
	private Computer computer;

	public BaseballGameService() {
		this.user = new User();
		this.computer = new Computer();
	}

	public void makeRandomNumber() {
		computer.generateAnswerNumber();
	}

	public void playGame() {
		while(true) {
			PrintUtil.printUserEnterNumberMessage();
			readUserInputNumber();
			Game game = new Game(computer.getAnswerNumberSet(), user.getExpectedNumberList());
			PrintUtil.printStrikeAndBallCnt(game);
			if (game.isClear()){
				PrintUtil.printGameClearMessage();
				break;
			}
		}
	}

	public boolean isRestartOrQuit() {
		return readUserRestartOrQuit().equals(GameRestartEnum.RESTART.getValue());
	}

	public boolean isRestart() {
		PrintUtil.printRestartOrQuitMessage();
		return isRestartOrQuit();
	}

	private void readUserInputNumber() {
		String inputNumber = readInput();
		user.setExpectedNumber(inputNumber);
	}

	private String readUserRestartOrQuit() {
		String inputNumber = readInput();
		ValidateInputUtil.validateRestartOrQuitNum(inputNumber);
		return inputNumber;
	}

	private String readInput() {
		return Console.readLine();
	}
}
