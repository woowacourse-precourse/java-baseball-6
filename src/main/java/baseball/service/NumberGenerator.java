package baseball.service;

import java.util.ArrayList;
import java.util.List;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
	public static String generateUniqueNumbers(int count) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			int temp = Randoms.pickNumberInRange(InputView.AVAILABLE_START_NUMBER, InputView.AVAILABLE_END_NUMBER);
			while (list.contains(temp)) {
				temp = Randoms.pickNumberInRange(InputView.AVAILABLE_START_NUMBER, InputView.AVAILABLE_END_NUMBER);
			}
			list.add(temp);
		}

		StringBuilder result = new StringBuilder();
		for (int digit : list) {
			result.append(digit);
		}
		return result.toString();
	}
}
