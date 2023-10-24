package baseball.global.util;

import baseball.global.exception.input.*;
import baseball.global.util.enums.GameRestartEnum;
import baseball.global.util.enums.NumberRangeEnum;

import java.util.HashSet;
import java.util.Set;

public class ValidateInputUtil {

	private ValidateInputUtil() {

	}

	public static void validateInputNumberIsValid(String number) {
		validateInputNumberLength(number);
		validateInputNumberIsDigit(number);
		validateNoDuplicateNumbersInInputNumber(number);
	}

	public static void validateRestartOrQuitNum(String number){
		if (!number.equals(GameRestartEnum.RESTART.getValue()) && !number.equals(GameRestartEnum.QUIT.getValue())){
			throw new NumberNotRestartOrQuitException();
		}
	}

	private static void validateInputNumberLength(String number) {
		int numberLength = number.length();
		if (numberLength < NumberRangeEnum.NUMBER_LENGTH.getValue()) {
			throw new NumberLengthBelowMinimumLengthException();
		}
		if (numberLength > NumberRangeEnum.NUMBER_LENGTH.getValue()) {
			throw new NumberLengthExceedMaximumLengthException();
		}
	}

	private static void validateInputNumberIsDigit(String number) {
		if (!number.matches("\\d+")) {
			throw new NumberNotDigitExcepton();
		}
	}

	private static void validateNoDuplicateNumbersInInputNumber(String number) {
		int distinctNumberCnt = calcDistinctNumberCntInInputNumber(number);

		if (distinctNumberCnt != number.length()) {
			throw new DuplicateNumbersInInputException();
		}
	}

	private static int calcDistinctNumberCntInInputNumber(String number) {
		StringBuilder sb = new StringBuilder();
		Set<Character> set = new HashSet<>();
		for (char c : number.toCharArray()) {
			if (set.add(c)) {
				sb.append(c);
			}
		}
		return sb.toString().length();
	}
}
