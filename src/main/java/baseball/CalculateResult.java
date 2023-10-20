package baseball;

import java.util.List;

public class CalculateResult {
	public int[] compare(List<Integer> computerNumbers, List<Integer> userNumbers) {

		int[] result = new int[2];

		for (int i = 0; i < 3; i++) {
			int userNumber = userNumbers.get(i);
			int computerNumber = computerNumbers.get(i);
			if (userNumber == computerNumber) {
				result[1]++;
			} else if (computerNumbers.contains(userNumber)) {
				result[0]++;
			}
		}
		return result;
	}

}
