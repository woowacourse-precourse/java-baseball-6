package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class AnswerGenerator {
	private final static int MAX_ARRAY_SIZE = 3;

	public static String getRandomNumber() {
		List<Integer> computer = new ArrayList<>();
		while (computer.size() < MAX_ARRAY_SIZE) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}
		String computerString = "";
		for (int i = 0; i < 3; i++) {
			computerString = "%s%d".formatted(computerString, computer.get(i));
		}
		return computerString;
	}
}
