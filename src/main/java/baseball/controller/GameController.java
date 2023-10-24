package baseball.controller;

import java.util.ArrayList;
import java.util.List;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.service.CalculateService;
import baseball.service.DecideNextGameService;
import baseball.view.GameStartView;
import baseball.view.InPlayView;

public class GameController {
	private static final int STRIKE_IDX = 0;
	private static final int ALL_CORRECT_CNT = 3;
	private final CalculateService calculateService = new CalculateService();
	private final DecideNextGameService decideNextGameService = new DecideNextGameService();
	private final GameStartView gameStartView = new GameStartView();
	private final InPlayView inPlayView = new InPlayView();
	private final User user = new User();
	private final Computer computer = new Computer();
	private List<Integer> strikeOrBallCnt = new ArrayList<>();

	public GameController() {
		printStart();
	}

	public void start() {
		computer.setComputerNumber();
		while (!decideNextGameService.isExit()) {
			setNumber();
			calculateStrikeOrBall();
			decideResult();
		}
	}

	public void printStart() {
		gameStartView.printStartMessage();
	}

	public void setNumber() {
		user.setUserNumber(gameStartView.setUserNumber());
	}

	public void calculateStrikeOrBall() {
		strikeOrBallCnt = calculateService.calculateNumber(computer.getComputerNumber(), user.getUserNumber());
	}

	public void checkThreeStrike() {
		if (strikeOrBallCnt.get(STRIKE_IDX) == ALL_CORRECT_CNT) {
			inPlayView.printCorrect();
			decideNextGameService.checkStatus(computer);
		}
	}

	public void checkNonThreeStrike() {
		if (strikeOrBallCnt.get(STRIKE_IDX) != ALL_CORRECT_CNT) {
			inPlayView.printNoCorrect(strikeOrBallCnt);
		}
	}

	public void decideResult() {
		checkThreeStrike();
		checkNonThreeStrike();
	}
}
