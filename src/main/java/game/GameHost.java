package game;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import participant.Computer;
import participant.Player;

public class GameHost {

	public static final int MAX_NUMBER_COUNT = 3;
	public static final int START_INCLUSIVE = 1;
	public static final int END_INCLUSIVE = 9;

	private int strikeCount = 0;
	private int ballCount = 0;
	private int nothingCount = MAX_NUMBER_COUNT;

	private Player player;
	private Computer computer;
	private List<String> computerRandomNumbers;
	private List<String> playerInputNumbers;

	public GameHost() {
		this.player = new Player();
		this.computer = new Computer();
		while (this.strikeCount != 3) {
			System.out.println(Message.PROVIDE_NUMBER_INPUT);
			this.player = new Player(Console.readLine());
			gameStart(computer.getComputerRandomNumbers(), player.getPlayerInputNumbers());
		}
	}

	private void gameStart(List<String> computerNumbers, List<String> playerInputNumbers) {
		for (int i = 0; i < computerNumbers.size(); i++) {
			compareComputerWithPlayer(i, computerNumbers.get(i), playerInputNumbers);
		}
	}

	private void compareComputerWithPlayer(int index, String computerNumber, List<String> playerInputNumbers) {
		for (int i = 0; i < playerInputNumbers.size(); i++) {
			if (i == index && computerNumber == playerInputNumbers.get(i)) {
				this.strikeCount++;
				this.nothingCount--;
			}
			if (i != index && computerNumber == playerInputNumbers.get(i)) {
				this.ballCount++;
				this.nothingCount--;
			}
		}

		printNowCount();
	}

	private void printNowCount() {
		if (this.strikeCount > 0 || this.ballCount > 0) {
			System.out.println(this.strikeCount + Message.STRIKE);
			System.out.println(this.ballCount + Message.BALL);
		}

		if (this.nothingCount == MAX_NUMBER_COUNT) {
			System.out.println(Message.NOTHING);
		}
	}


}
