package baseball.domain.computer;

import java.util.List;
import java.util.Map;

class BallResult {

	private BallResult() {
		throw new AssertionError();
	}

	public static String generateResult(final List<Integer> userNumbers, final Map<Integer, Integer> computerNumbers) {
		int strike = 0;
		int ball = 0;
		for (int i = 0; i < userNumbers.size(); i++) {
			final int userNumber = userNumbers.get(i);
			if (computerNumbers.containsKey(userNumber)) {
				final Integer index = computerNumbers.get(userNumber);
				if (index == i) {
					strike++;
				} else {
					ball++;
				}
			}
		}
		final StringBuilder result = new StringBuilder();
		if (ball != 0) {
			final String ballResult = String.format("%d볼", ball);
			result.append(ballResult);
		}
		if (strike != 0) {
			if (!result.isEmpty()) {
				result.append(" ");
			}
			final String strikeResult = String.format("%d스트라이크", strike);
			result.append(strikeResult);
		}
		if (result.isEmpty()) {
			result.append("낫싱");
		}
		return result.toString();
	}
}
