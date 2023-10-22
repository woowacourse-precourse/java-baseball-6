package baseball.console;

import baseball.utils.StringUtils;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Console {

	private Console() {
	}

	public static void printGameStart() {
		ConsoleOutput.printGameStart();
	}

	public static void printInputMessage() {
		ConsoleOutput.printInputMessage();
	}

	public static void printResultMessage(int ball, int strike) { ConsoleOutput.printResultMessage(ball, strike); }

	public static void printFinishMessage() {
		ConsoleOutput.printFinishMessage();
	}
	public static String getUserNumber() {
		printInputMessage();
		return ConsoleInput.getUserNumber();
	}

	public static int[] getUserNumberArray() {
		return StringUtils.parseStringToIntArray(getUserNumber());
	}

	public static int[] getComputerNumberArray() {
		List<Integer> list = new ArrayList<>();
		while (list.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!list.contains(randomNumber)) {
				list.add(randomNumber);
			}
		}
		return list.stream().mapToInt(i -> i).toArray();
	}

	public static boolean getResumeOption() {
		ConsoleOutput.printResumeMessage();
		String inputString = ConsoleInput.getResumeOption();
		if (inputString.equals("1")) {
			return true;
		} else {
			return false;
		}
	}

}
