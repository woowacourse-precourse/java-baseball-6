package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class AnswerGenerator {
	private final static int MAX_NUMBER_SIZE = 3;

	public static String getRandomNumber() {
		List<Integer> computer = new ArrayList<>();
		String computerString = "";
		while (computer.size() < MAX_NUMBER_SIZE) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
				computerString += randomNumber;
			}
		}
		return computerString;
	}
}
