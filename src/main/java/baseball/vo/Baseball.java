package baseball.vo;

import java.util.ArrayList;
import java.util.Arrays;

public class Baseball {
	private String[] userChoiceNumberResult;
	private ArrayList<Character> computerChoiceNumberResult;
	private String computerNumber;
	private int ball;
	private int strike;

	public Baseball() {}

	public String[] getUserChoiceNumberResult() {
		return userChoiceNumberResult;
	}

	public void setUserChoiceNumberResult(String[] userChoiceNumberResult) {
		this.userChoiceNumberResult = userChoiceNumberResult;
	}

	public ArrayList<Character> getComputerChoiceNumberResult() {
		return computerChoiceNumberResult;
	}

	public void setComputerChoiceNumberResult(ArrayList<Character> computerChoiceNumberResult) {
		this.computerChoiceNumberResult = computerChoiceNumberResult;
	}

	public String getComputerNumber() {
		return computerNumber;
	}

	public void setComputerNumber(String computerNumber) {
		this.computerNumber = computerNumber;
	}

	public int getBall() {
		return ball;
	}

	public void setBall(int ball) {
		this.ball = ball;
	}

	public int getStrike() {
		return strike;
	}

	public void setStrike(int strike) {
		this.strike = strike;
	}

	@Override
	public String toString() {
		return "Baseball [userChoiceNumberResult=" + Arrays.toString(userChoiceNumberResult)
				+ ", computerChoiceNumberResult=" + computerChoiceNumberResult + ", computerNumber=" + computerNumber
				+ ", ball=" + ball + ", strike=" + strike + "]";
	}
	
	




}
