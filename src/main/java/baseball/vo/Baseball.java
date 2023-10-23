package baseball.vo;

public class Baseball {
	private String computerNumber;
	private int ball;
	private int strike;

	public Baseball() {}

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
		return "Baseball [computerNumber=" + computerNumber + ", ball=" + ball + ", strike=" + strike + "]";
	}

	



}
