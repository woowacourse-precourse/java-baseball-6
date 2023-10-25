package baseball;

import java.util.ArrayList;
import java.util.List;

import baseball.message.ErrorMessage;
import baseball.message.Message;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
	private static boolean inputCondition;
	private int ball;
	private int strike;
	private final List<Integer> computer;
	private final List<Integer> player;

	public Game() {
		computer = new ArrayList<>();
		player = new ArrayList<>();
		inputCondition = true;
		ball = 0;
		strike = 0;
	}

	private void newGame() {
		selectNumbersByComputer(computer);

		while (inputCondition) {
			System.out.print(Message.pleaseInput.getMessage());
			String input = Console.readLine();
			isPlayerInputValid(input);

			getBallCounts(getComputerNumberList(), getPlayerNumberList());
			inputCondition = checkGameCondition(ball, strike);
			ball = 0;
			strike = 0;
			player.clear();
		}
	}

	public void getNewGame() {
		newGame();
	}

	private void selectNumbersByComputer(List<Integer> computer) {
		while (computer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			addNumberIfDifferent(computer, randomNumber);
		}
	}

	private void addNumberIfDifferent(List<Integer> integerList, int randomNumber) {
		if (!integerList.contains(randomNumber)) {
			integerList.add(randomNumber);
		}
	}

	private void isPlayerInputValid(String input) throws IllegalArgumentException {
		try {
			throwExceptionIfInvalid(input);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	private void throwExceptionIfInvalid(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.NOT_AN_INTEGER.getMessage());
		}
		if (input.length() != 3) {
			throw new IllegalArgumentException(ErrorMessage.EXCEED_MAX_LENGTH.getMessage());
		} else {
			checkEqualityOfPlayerInput(input);
		}
	}

	private void checkEqualityOfPlayerInput(String input) {
		for (int i = 0; i < input.length(); i++) {
			addNumberIfDifferent(player, Integer.parseInt(String.valueOf(input.charAt(i))));
		}
		if (player.size() < 3) {
			throw new IllegalArgumentException(ErrorMessage.NOT_UNIQUE_NUMBER.getMessage());
		}
	}

	private boolean checkGameCondition(int ball, int strike) {
		if (strike == 3) {
			System.out.println(Message.threeStrikes.getMessage());
			System.out.print(Message.congrats.getMessage());
			System.out.println(Message.gameOver.getMessage());
			return false;
		} else if (ball > 0) {
			System.out.printf("%d볼 %d스트라이크", ball - strike, strike);
		} else {
			System.out.println(Message.nothing.getMessage());
		}
		return true;
	}

	private void getBallCounts(List<Integer> computerNumberList, List<Integer> playerNumberList) {
		for (Integer n : computerNumberList) {
			increaseBallCount(playerNumberList, n);
		}
		for (int i = 0; i < computerNumberList.size(); i++) {
			increaseStrikeCount(computerNumberList, playerNumberList, i);
		}
	}

	private void increaseStrikeCount(List<Integer> computerNumberList, List<Integer> playerNumberList, Integer i) {
		if (computerNumberList.get(i).equals(playerNumberList.get(i))) {
			strike++;
		}
	}

	private void increaseBallCount(List<Integer> playerNumberList, Integer n) {
		if (playerNumberList.contains(n)) {
			ball++;
		}
	}

	public List<Integer> getComputerNumberList() {
		return this.computer;
	}

	public List<Integer> getPlayerNumberList() {
		return this.player;
	}

}
