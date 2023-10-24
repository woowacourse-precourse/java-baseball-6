package baseball.model;

import java.util.List;

public class NumberOfGame {
	private String input;
	private List<Integer> userNumber;
	private List<Integer> computerNumber;
	
	public void setInput(String input) {
		this.input = input;
	}
	public String getInput() {
		return this.input;
	}
	
	public void setUserNumber(List<Integer> userNumber) {
		this.userNumber = userNumber;
	}
	
	public List<Integer> getUserNumber(){
		return this.userNumber;
	}
	
	public void setComputerNumber(List<Integer> computerNumber) {
		this.computerNumber = computerNumber;
	}
	
	public List<Integer> getCoomputerNumber(){
		return this.computerNumber;
	}
}
