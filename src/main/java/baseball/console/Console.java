package baseball.console;

import baseball.utils.StringUtils;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Console {
	private static ConsoleInput consoleInput;
	private static ConsoleOutput consoleOutput;
	private static String ballMessage = "볼 ";
	private static String strikeMessage = "스트라이크";
	private static String nothingMessage = "낫싱";


	public static void printGameStart() {
		ConsoleOutput.printGameStart();
	}

	public static void printInputMessage() {
		ConsoleOutput.printInputMessage();
	}

	public static String getUserNumber() {
		String inputString = ConsoleInput.getUserNumber();
		StringUtils.checkInputFormat(inputString);
		return inputString.trim();
	}

	public static int[] getUserNumberArray() {
		int[] numberArray = StringUtils.parseStringToIntArray(getUserNumber());
		return numberArray;
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

	public static void printResultMessage(int ball, int strike) {
		String message = "";
		if (ball > 0) {
			message += ball + ballMessage;
		}
		if (strike > 0) {
			message += strike + strikeMessage;
		}
		if (strike == 0 && ball == 0) {
			message += nothingMessage;
		}
		ConsoleOutput.println(message);
	}

	public static void printFinishMessage() {
		ConsoleOutput.printFinishMessage();
	}

	public static boolean getResumeOption() {
		ConsoleOutput.printResumeMessage();
		String inputString = ConsoleInput.getUserNumber();
		StringUtils.checkResumeInputFormat(inputString);
		if (inputString.equals("1")) {
			return true;
		} else {
			return false;
		}
	}

}
