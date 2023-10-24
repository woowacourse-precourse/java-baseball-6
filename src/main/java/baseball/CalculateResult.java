package baseball;

import java.util.List;

public class CalculateResult {

	private static final int NUMBER_LENGTH = 3;
	private static final int BALL = 0;
	private static final int STRIKE = 1;

	public int[] compare(List<Integer> computerNumbers, List<Integer> userNumbers) {

		int[] result = new int[2];

		for (int i = 0; i < NUMBER_LENGTH; i++) {
			int userNumber = userNumbers.get(i);
			int computerNumber = computerNumbers.get(i);
			if (userNumber == computerNumber) {
				result[STRIKE]++;
			} else if (computerNumbers.contains(userNumber)) {
				result[BALL]++;
			}
		}
		return result;
	}

}
