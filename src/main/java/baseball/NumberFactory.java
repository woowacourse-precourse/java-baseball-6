package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberFactory {
	private static final int START_NUMBER = 0;
	private static final int END_NUMBER = 0;

	public static String createRandomNumbers(int size) {
		return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, size).toString();
	}
}
