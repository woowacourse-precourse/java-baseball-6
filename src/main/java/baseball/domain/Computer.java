package baseball.domain;

import static baseball.global.constant.BaseballConstant.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	private List<Integer> numbers;


	public void generate() {
		numbers = new ArrayList<>();
		while (numbers.size() < PLAY_AMOUNT) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!numbers.contains(randomNumber)) {
				numbers.add(randomNumber);
			}
		}
	}

	public int getNumberOf(int index) {
		return numbers.get(index);
	}

	public boolean contains(int number) {
		return this.numbers.contains(number);
	}

}
