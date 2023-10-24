package woowa.hyunho.game;

import java.util.List;
import woowa.hyunho.messages.Messages;
import woowa.hyunho.number.User;
import woowa.hyunho.utilities.Compare;

public class Game {
	static final int NUMBER_LENGTH = 3;
	static final int INDEXOFSTRIKE = 0;
	static final int INDEXOFBALL = 1;
	List<Integer> computerNumberList;
	List<Integer> userNumberList;
	
	public void startBaseball(List<Integer> computerRandomNumber) {
		computerNumberList = computerRandomNumber;
		User user = new User();
		playBaseBall(user, computerRandomNumber);
		gameClear();
	}
	
	private void playBaseBall(User user, List<Integer> computerRandomNumber) {
		int strike = 0;
		int ball = 0;
		do {
			userNumberList = getUserNumber(user);
			List<Integer> strikeAndBall = Compare.countStrikeAndBall(computerNumberList, userNumberList);
			strike = getStrike(strikeAndBall);
			ball = getBall(strikeAndBall);
			Messages.printResult(ball, strike);
		} while(strike != NUMBER_LENGTH);
	}
	
	private List<Integer> getUserNumber(User user) {
		Messages.askInput();
		return user.generateUserNumberList();
	}
	
	private int getStrike(List<Integer> result) {
		return result.get(INDEXOFSTRIKE);
	}
	
	private int getBall(List<Integer> result) {
		return result.get(INDEXOFBALL);
	}
	
	private void gameClear() {
		Messages.printEnd();
	}
	
}