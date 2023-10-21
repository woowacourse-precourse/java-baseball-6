package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Referee;
import baseball.util.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;
import java.util.regex.Matcher;

public class BaseballGameController {
	private boolean continueGame = true;
	public void run() {
		OutputView.printStart();
		Computer computer = new Computer();
		Player player = new Player();
		Referee referee = new Referee();
		repeatGame(computer, player, referee);
	}

	private void repeatGame(Computer computer, Player player, Referee referee) {
		computer.setComputerNumber();
		List <Integer> computerNumber = computer.getComputerNumber();
		while (continueGame) {
			String playerNumber = InputView.inputNumber();
			player.setPlayerNumber(playerNumber);
		}
	}

	private void isValidPlayerNumber(String number) {
		String answerValidationRegex = "^(?!.*(.).*\\1)[1-9]{3}$";
		InputValidator.validateInput(answerValidationRegex, number);
	}

	private void isValidRestartOrEndNumber(String number) {
		String oneOrTwoValidationRegex = "^[12]$";
		InputValidator.validateInput(oneOrTwoValidationRegex, number);
	}

}
