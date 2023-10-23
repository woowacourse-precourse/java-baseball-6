package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	private List<Integer> computerNumbers = new ArrayList<>();

	public Computer() {
		generateRandomNumbers();
	}

	public List<Integer> getComputerNumbers() {
		return computerNumbers;
	}

	private void generateRandomNumbers() {

		while (computerNumbers.size() != 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);

			if (!computerNumbers.contains(randomNumber)) {
				computerNumbers.add(randomNumber);
			}
		}
	}
}
