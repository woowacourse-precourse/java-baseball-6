package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private List<Integer> numberList = new ArrayList<>();

	public void init() {
		numberList.clear();
		while (numberList.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!numberList.contains(randomNumber)) {
				numberList.add(randomNumber);
			}
		}
	}

	public List<Integer> getNumberList() {
		return numberList;
	}
}
