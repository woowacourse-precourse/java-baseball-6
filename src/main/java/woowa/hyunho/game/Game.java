package woowa.hyunho.game;

import java.util.List;
import woowa.hyunho.messages.Messages;
import woowa.hyunho.number.User;
import woowa.hyunho.number.Computer;
import woowa.hyunho.utilities.Compare;
import woowa.hyunho.utilities.Parse;

public class Game {
	static final int NUMBER_LENGTH = 3;
	
	int strike = 0;
	int ball = 0;
	User user = new User();
	Computer computer;
	
	public void startBaseball(Computer computer) {
		this.computer = computer;
		do {
			getNumber();
			playBaseball();
		} while(strike != NUMBER_LENGTH);
		gameClear();
	}
	
	private void getNumber() {
		Messages.askInput();
		user.setNumber();
	}
	
	private void playBaseball() {
		List<Integer> computerNumberList = getComputerNumberList();
		List<Integer> userNumberList = getUserNumberList();
		List<Integer> result = Compare.countResult(computerNumberList, userNumberList);
		strike = getStrike(result);
		ball = getBall(result);
		Messages.printResult(ball, strike);
	}
	
	private List<Integer> getComputerNumberList() {
		return computer.getRandomNumber();
	}
	
	private List<Integer> getUserNumberList() {
		return Parse.parseStringToIntList(user.getNumber());
	}
	
	private int getStrike(List<Integer> result) {
		return result.get(0);
	}
	
	private int getBall(List<Integer> result) {
		return result.get(1);
	}
	
	private void gameClear() {
		Messages.printEnd();
	}
	
}