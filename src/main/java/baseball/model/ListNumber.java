package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class ListNumber {
	private final List<Integer> baseballNumber;

	public ListNumber(int number) {
		baseballNumber = new ArrayList<>();
		String inputNumber = Integer.toString(number);
		for (int i = 0; i < inputNumber.length(); i++) {
			baseballNumber.add(Integer.parseInt(String.valueOf(inputNumber.charAt(i))));
		}
	}

	public int getIndex(int index) {
		return baseballNumber.get(index);
	}

	public boolean contains(int number) {
		return baseballNumber.contains(number);
	}
}
