package baseball.utils;

import baseball.exception.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringUtils {

	private StringUtils() {
	}

	public static void checkInputFormat(String inputString) throws IllegalArgumentException {
		String removedBlankString = removeBlank(inputString);
		validateIntegerInput(removedBlankString);
		validateIntegerLength(removedBlankString, 3);
		validateDuplicatedNumber(removedBlankString);
		validateNotZero(removedBlankString);
	}

	public static void checkResumeInputFormat(String inputString) throws IllegalArgumentException {
		String removedBlankString = removeBlank(inputString);
		validateIntegerInput(removedBlankString);
		validateIntegerLength(removedBlankString, 1);
		validateResumeFormat(removedBlankString);
	}

	private static void validateNotZero(String removedBlankString) throws UsingZeroInputException {
		if (isZeroIncluded(removedBlankString)) {
			throw new UsingZeroInputException(removedBlankString);
		}

	}

	private static void validateResumeFormat(String removedBlankString) throws NotValidResumeInputException {
		if (!removedBlankString.equals("1") && !removedBlankString.equals("2")) {
			throw new NotValidResumeInputException(removedBlankString);
		}
	}

	private static void validateIntegerInput(String inputString) throws NotIntegerInputException {
		if (!isInteger(inputString)) {
			throw new NotIntegerInputException(inputString);
		}
	}

	private static void validateIntegerLength(String inputString, int N) throws OutOfLengthInputException {
		if (!isLengthSameAsN(inputString, N)) {
			throw new OutOfLengthInputException(inputString, N);
		}
	}

	private static void validateDuplicatedNumber(String inputString) throws DuplicatedInputException {
		if (isDuplicated(inputString)) {
			throw new DuplicatedInputException(inputString);
		}
	}

	private static boolean isZeroIncluded(String removedBlankString) {
		String[] array = removedBlankString.split("");
		for (String x : array) {
			if (x.equals("0")) {
				return true;
			}
		}
		return false;
	}

	public static int[] parseStringToIntArray(String inputString) {
		String[] array = inputString.split("");
		int[] numberArray = new int[3];
		for (int i = 0; i < 3; i++) {
			numberArray[i] = Integer.parseInt(array[i]);
		}
		return numberArray;
	}


	private static boolean isInteger(String inputString) {
		try {
			Integer.parseInt(inputString);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private static boolean isLengthSameAsN(String inputString, int N) {
		return inputString.length() == N;
	}

	private static boolean isDuplicated(String inputString) {
		String[] array = inputString.split("");
		Set<String> set = new HashSet<>(Arrays.asList(array));
		return set.size() != array.length;
	}

	private static String removeBlank(String input) {
		return input.replaceAll("\\s+", "").trim();
	}

}
