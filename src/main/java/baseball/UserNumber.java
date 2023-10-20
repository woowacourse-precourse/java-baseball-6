package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class UserNumber {
	public List<Integer> userNumbers() {
		List<Integer> user = new ArrayList<>();
		while (user.size() < 3) {
			System.out.print("숫자를 입력해주세요 : ");

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
