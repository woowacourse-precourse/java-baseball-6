package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Input {

	private static final int NUMBER_RANGE_MIN = 1;
	private static final int NUMBER_RANGE_MAX = 9;

	private static final String RESTART_BUTTON = "1";
	private static final String END_BUTTON = "2";

	public static List<Integer> inputUserNumber(int numberSize) {
		System.out.print("숫자를 입력해주세요 : ");
		String userInput = Console.readLine();

		if (userInput.length() != numberSize) {
			throw new IllegalArgumentException("세 자리의 숫자를 입력해주세요.");
		}
		if (userInput.replaceAll("\\s", "").length() < numberSize) {
			throw new IllegalArgumentException("공백을 제외한 세 자리 수를 입력해주세요.");
		}

		List<Integer> userNumbers = userInputToInteger(userInput);
		for (int userNumber : userNumbers) {
			if(userNumber < NUMBER_RANGE_MIN || userNumber > NUMBER_RANGE_MAX) {
				throw new IllegalArgumentException("1부터 9까지의 숫자를 입력해주세요.");
			}
		}

		Set<Integer> deleteDuplicate = new HashSet<>(userNumbers);
		if (deleteDuplicate.size() != userNumbers.size()) {
			throw new IllegalArgumentException("중복 되지 않은 수를 입력해주세요.");
		}

		return userNumbers;
	}

	private static List<Integer> userInputToInteger(String userInput) {
		List<Integer> userNumbers = new ArrayList<>();
		for (String inputStr : userInput.split("")) {
			try {
				int userNumberInt = Integer.parseInt(inputStr);
				userNumbers.add(userNumberInt);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("숫자만 입력 가능합니다.");
			}
		}
		return userNumbers;
	}

	public static List<Integer> getRandomNumber(int numberSize) {
		List<Integer> randomNumbers = new ArrayList<>();
		while (randomNumbers.size() < numberSize) {
			int random = Randoms.pickNumberInRange(NUMBER_RANGE_MIN, NUMBER_RANGE_MAX);
			if(!randomNumbers.contains(random)) {
				randomNumbers.add(random);
			}
		}
		return randomNumbers;
	}

	public static boolean restartOrNot() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String userInput = Console.readLine();
		if (RESTART_BUTTON.equals(userInput)) {
			return true;
		}
		if (END_BUTTON.equals(userInput)) {
			return false;
		}
		throw new IllegalArgumentException("1또는 2를 입력해주세요.");
	}
}
