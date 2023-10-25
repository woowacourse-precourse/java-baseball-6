package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomBaseBallGenerator implements BaseBallGenerator {

	private static final int MIN_NUMBER_RANGE = 1;
	private static final int MAX_NUMBER_RANGE = 9;
	private static final int CHECK_DIGIT_RANGE = 10;

	// StringBuilder sb가 정수 n을 포함하는지 판단한다.
	private boolean baseballContains(StringBuilder sb, int n) {
		// 점수 디버깅
//		System.out.println(Character.forDigit(n, 10));
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == Character.forDigit(n, CHECK_DIGIT_RANGE)) {
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