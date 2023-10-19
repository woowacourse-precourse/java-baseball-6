package baseball;

import java.util.List;

public class GameData {
	Computer computer;

	public void initComputer() {
		computer = new Computer();
	}


	public List<Integer> calculateResult(List<Integer> trial) {
		return computer.calculateResult(trial);
	}
}
