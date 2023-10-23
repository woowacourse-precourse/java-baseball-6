package baseball;

import camp.nextstep.edu.missionutils.*;
import java.util.InputMismatchException;
import java.util.List;

/*
숫자 야구 게임을 시작합니다.
숫자를 입력해주세요 : 123
1볼 1스트라이크
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
...
 */
public class Application {

	public static boolean isValid(String input) {
		try {
			if (input.length() != 3) {
				return false;
			}
			if (Integer.parseInt(input) < 100 || Integer.parseInt(input) > 999) {
				return false;
			}
			if (input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2)
					|| input.charAt(0) == input.charAt(2)) {
				return false;
			}
		} catch (InputMismatchException e) {
			throw new IllegalArgumentException("숫자만 입력해주세요.");
		}
		return true;
	}

	public static void main(String[] args) {

		final int INPUT_LIMIT = 3;

		System.out.println("숫자 야구 게임을 시작합니다.");

		// Computer Randomized Number Generate
		List<Integer> computerNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
		System.out.println(computerNumbers);


		// User Input process
		boolean isCorrect = false;
		while (!isCorrect) {

			System.out.print("숫자를 입력해주세요 : ");
			// TODO: Input Validation
			String line = Console.readLine();

			int ball = 0, strike = 0;
			for (int index = 0; index < INPUT_LIMIT; index++) {
				int num = Character.getNumericValue(line.charAt(index));
				if (computerNumbers.get(index) == num) {
					strike++;
				} else if (computerNumbers.contains(num)) {
					ball++;
				}
			}

		}
	}
}