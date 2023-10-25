package baseball.vo;

import java.util.Arrays;

/*
 * 	getter setter
 */
public class Baseball {
	private String computerNumber;
	private String[] userChoiceNumber;
	private int ball;
	private int strike;

	public Baseball() {}

	public String getComputerNumber() {
		return computerNumber;
	}

	public void setComputerNumber(String computerNumber) {
		this.computerNumber = computerNumber;
	}

	public String[] getUserChoiceNumber() {
		return userChoiceNumber;
	}

	public void setUserChoiceNumber(String[] userChoiceNumber) {
		this.userChoiceNumber = userChoiceNumber;
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
		return "Baseball [computerNumber=" + computerNumber + ", userChoiceNumber=" + Arrays.toString(userChoiceNumber)
				+ ", ball=" + ball + ", strike=" + strike + "]";
	}

	



}
