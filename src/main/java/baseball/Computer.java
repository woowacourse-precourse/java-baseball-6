package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
	public List<Integer> numbers = new ArrayList<>();

	public void init() {
		numbers.clear();

		while (numbers.size() < Constants.NUMBER_LENGTH) {
			int number = Randoms.pickNumberInRange(1, 9);

			if (!numbers.contains(number)) {
				numbers.add(number);
			}
		}
	}
}
