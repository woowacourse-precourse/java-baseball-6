package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomBaseBallGenerator implements BaseBallGenerator {

	private static final int MIN_NUMBER_RANGE = 1;
	private static final int MAX_NUMBER_RANGE = 9;
	private static final int DIGIT_RADIX = 10;

	// StringBuilder sb가 정수 n을 포함하는지 판단한다.
	private boolean baseballContains(StringBuilder sb, int n) {
//		System.out.println(Character.forDigit(n, 10)); // 난수 확인용
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == Character.forDigit(n, DIGIT_RADIX)) {
				return true;
			}
		}
		return false;
	}

	public BaseBall generate() {
		StringBuilder sb = new StringBuilder();
		while (sb.length() < 3) {
			int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
			if (!baseballContains(sb, randomNumber)) {
				sb.append(randomNumber);
			}
		}
		return new BaseBall(sb.toString());
	}
}