package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberFactory {
	private static final int START_NUMBER = 1;
	private static final int END_NUMBER = 9;

	public static String createRandomNumbers(int size) {
		return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, size).toString();
	}
}
