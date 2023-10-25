package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CreateNumber {

	private static final Integer NUMBER_SIZE = 3;

	public List<Integer> createComputerNumber(int numberSize) {
		List<Integer> computer = new ArrayList<>();
		while (computer.size() < numberSize) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}

		return computer;
	}

	public List<Integer> createUserNumber() {
		List<Integer> user = new ArrayList<>();
		try {
			String number = Console.readLine();
			if (number.length() != NUMBER_SIZE) {
				throw new IllegalArgumentException();
			}

			for (String n : number.split("")) {
				user.add(Integer.parseInt(n));
			}

		} catch (IllegalArgumentException e) {
			return user;
		}
		return user;
	}
}
