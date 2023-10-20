package baseball;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BaseballGame {
	private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
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
			System.out.print(INPUT_MESSAGE);
			player.setNumber();

			computerNumber = computer.getRandomNumber();
			playerNumber = player.getNumber();

			boolean success = compareComputerPlayer(computerNumber, playerNumber);
		}
	}

	public boolean compareComputerPlayer(List computerNumber, List playerNumber) {
		if (computerNumber.equals(playerNumber)) {
			return true;
		}
		return false;
	}


}
