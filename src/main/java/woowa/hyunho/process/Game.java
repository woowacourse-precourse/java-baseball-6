package woowa.hyunho.process;

import java.util.List;

import woowa.hyunho.messages.Messages;
import woowa.hyunho.number.User;
import woowa.hyunho.number.Computer;
import woowa.hyunho.utilities.Compare;
import woowa.hyunho.utilities.Parse;

public class Game {
	static final int NUMBER_LENGTH = 3;
	User user = new User();
	Computer computer;
	
	public void startBaseball(Computer computer) {
		this.computer = computer;
		int strike = 0;
		do {
			getNumber();
			strike = playBaseball();
		} while(strike != NUMBER_LENGTH);
		gameClear();
	}
	
	private void getNumber() {
		Messages.askInput();
		user.setNumber();
	}
	
	private int playBaseball() {
		int strike = 0;
		int ball = 0;
		List<Integer> userList = Parse.parseString(user.getNumber());
		strike = Compare.checkStrike(computer.getRandomNumber(), userList);
		ball = Compare.checkBall(computer.getRandomNumber(), userList) - strike;
		Messages.printResult(ball, strike);
		return strike;
	}
	
	private void gameClear() {
		Messages.printEnd();
	}
	
}