//GameModel.java
package baseball;

import java.util.List;

public class GameModel {
	private List<Integer> computerNumber;
	private boolean isCorrect;

	GameModel(List<Integer> computerNumber){
		this.computerNumber = computerNumber;
		this.isCorrect = false;
	}

	public List<Integer> getComputerNumber(){
		return this.computerNumber;
	}

	public boolean getIsCorrect(){
		return this.isCorrect;
	}

	public void setIsCorrect(boolean isCorrect){
		this.isCorrect = isCorrect;
	}
}
