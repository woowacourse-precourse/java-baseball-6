package baseball.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumber {
	private List<Integer> computerNumber;

	public ComputerNumber() {
		this.computerNumber = computerNumber();
	}

	public List<Integer> getComputerNumber() {
		return computerNumber;
	}

	public void resetComputerNumber(){
		this.computerNumber = computerNumber();
	}

	private List<Integer> computerNumber() {
		List<Integer> computer = new ArrayList<>();
		while (computer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}
		return computer;
	}
}
