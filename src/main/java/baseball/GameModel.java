package baseball;

import java.util.List;

public class GameModel {
	List<Integer> computerNumber;
	boolean isSuccess;

	GameModel(List<Integer> computerNumber){
		this.computerNumber = computerNumber;
		this.isSuccess = false;
	}
}
