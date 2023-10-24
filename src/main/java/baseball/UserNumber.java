package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class UserNumber {
	private static final int NUMBER_LENGTH = 3;
	private static final String OUTPUT_ENTER_NUMBER = "숫자를 입력해주세요 : ";

	public List<Integer> userNumbers() {
		List<Integer> user = new ArrayList<>();
		while (user.size() < NUMBER_LENGTH) {
			System.out.print(OUTPUT_ENTER_NUMBER);

			String input = Console.readLine();

			if (input.length() != 3) {
				throw new IllegalArgumentException();
			}
			if (input.contains("0")) {
				throw new IllegalArgumentException();
			}

			for (String number : input.split("")) {
				user.add(Integer.parseInt(number));
			}
		}
		return user;
	}
}
