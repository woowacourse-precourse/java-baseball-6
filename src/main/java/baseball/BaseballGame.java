package baseball;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BaseballGame {

	private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private boolean quit = false;
	private Computer computer = new Computer();
	private Player player = new Player();
	private List<Integer> computerNumber = new ArrayList<>();
	private List<Integer> playerNumber = new ArrayList<>();


	public BaseballGame() {
	}

	public void run() {
		System.out.println(START_MESSAGE);
		computer.setRandomNumber();
		while (!quit) {
			System.out.println(computer.getRandomNumber());
			System.out.print(INPUT_MESSAGE);
			player.setNumber();

			computerNumber = computer.getRandomNumber();
			playerNumber = player.getNumber();

			boolean success = compareComputerPlayer(computerNumber, playerNumber);

			if (!success) {
				printStrikeAndBall(computerNumber, playerNumber);
			}
		}
	}

	private boolean compareComputerPlayer(List computerNumber, List playerNumber) {
		if (computerNumber.equals(playerNumber)) {
			return true;
		}
		return false;
	}

	private void printStrikeAndBall(List computerNumber, List playerNumber) {
		int ball = calculateBall(computerNumber, playerNumber);
		int strike = calculateStrikes(computerNumber, playerNumber);

		if (ball != 0) {
			System.out.print(ball + "볼 ");
		}
		if (strike != 0) {
			System.out.print(strike + "스트라이크");
		}
		if (ball == 0 && strike == 0) {
			System.out.print("낫싱");
		}
		System.out.println();
	}

	private int calculateBall(List<Integer> computerNumber, List<Integer> playerNumber) {
		int ball = 0;

		for (int i = 0; i < computerNumber.size(); i++) {
			for (int j = 0; j < playerNumber.size(); j++) {
				if (i != j && computerNumber.get(i).equals(playerNumber.get(j))) {
					ball++;
				}
			}
		}

		return ball;
	}

	private int calculateStrikes(List<Integer> computerNumber, List<Integer> playerNumber) {
		int strike = 0;

		for (int i = 0; i < computerNumber.size(); i++) {
			if (computerNumber.get(i).equals(playerNumber.get(i))) {
				strike++;
			}
		}

		return strike;
	}
}
