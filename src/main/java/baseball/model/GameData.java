package baseball.model;

import java.util.List;

public class GameData {
	private String inputString;
	private List<Integer> playerNumbers;
	private List<Integer> computerNumbers;
	private int strikeCount;
	private int ballCount;
	public void setInputString(String inputString) {
		this.inputString = inputString;
	}
	public String getInputString() {
		return inputString;
	}
	public void setPlayerNumbers(List<Integer> playerNumbers) {
		this.playerNumbers = playerNumbers;
	}
	public List<Integer> getPlayerNumbers() {
		return playerNumbers;
	}
	public void setComputerNumbers(List<Integer> computerNumbers) {
		this.computerNumbers = computerNumbers;
	}
	public List<Integer> getComputerNumbers() {
		return computerNumbers;
	}

	public int getBallCount() {
		return ballCount;
	}

	public void setBallCount(int ballCount) {
		this.ballCount = ballCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public void setStrikeCount(int strikeCount) {
		this.strikeCount = strikeCount;
	}
}
