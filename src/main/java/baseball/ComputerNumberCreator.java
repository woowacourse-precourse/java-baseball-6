package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

//컴퓨터의 숫자를 생성하는 기능
public class ComputerNumberCreator {

	static List<Integer> createComputerNumber() {

		List<Integer> computerNumber = new ArrayList<>();

		final int COMPUTER_NUMBER_SIZE = 3;
		final int COMPUTER_MIN_NUMBER = 1;
		final int COMPUTER_MAX_NUMBER = 9;

		while (computerNumber.size() < COMPUTER_NUMBER_SIZE) {
			int randomNumber = Randoms.pickNumberInRange(COMPUTER_MIN_NUMBER, COMPUTER_MAX_NUMBER);

			if (!computerNumber.contains(randomNumber)) {
				computerNumber.add(randomNumber);
			}
		}

		return computerNumber;
	}
}
