package participant;

import camp.nextstep.edu.missionutils.Console;
import game.Message;
import java.util.ArrayList;
import java.util.List;
import valid.Validator;

public class Player {

	private String playerInputNumber;
	private List<String> playerInputNumbers;

	public Player() {
		this.playerInputNumber = inputPlayerNumber();
		new Validator(playerInputNumber);
		this.playerInputNumbers = toArrayList(playerInputNumber);
	}

	public Player(String inputNumbers) {
		new Validator(inputNumbers);
		this.playerInputNumbers = toArrayList(inputNumbers);
	}

	private String inputPlayerNumber() {
		System.out.println(Message.GAME_START_MESSAGE);
		System.out.print(Message.PROVIDE_NUMBER_INPUT);
		return Console.readLine();
	}

	private List<String> toArrayList(String playerInputNumber) {
		List<String> processedList = new ArrayList<>();
		for (int i = 0; i < playerInputNumber.length(); i++) {
			processedList.add(String.valueOf(playerInputNumber.charAt(i)));
		}
		return processedList;
	}

	public List<String> getPlayerInputNumbers() {
		return playerInputNumbers;
	}
}
