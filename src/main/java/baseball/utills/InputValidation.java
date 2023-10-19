package baseball.utills;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class InputValidation {
	private static final int NUMBER_LENGTH = 3;
	private static final String WRONG_INPUT_LENGTH_MESSAGE = "세 자리만 입력 가능합니다.";
	private static final String WRONG_INPUT_RANGE_MESSAGE = "1~9 사이의 숫자만 입력 가능합니다.";
	private static final String WRONG_INPUT_DUPLICATE_MESSAGE = "서로 다른 세자리 숫자만 입력 가능합니다.";
	public static String validate(String inputNumber){
		if(!hasExactLength(inputNumber)){
			throw new IllegalArgumentException(WRONG_INPUT_LENGTH_MESSAGE);
		}
		if(!hasExactRange(inputNumber)){
			throw new IllegalArgumentException(WRONG_INPUT_RANGE_MESSAGE);
		}
		if(!hasExactDuplicate(inputNumber)){
			throw new IllegalArgumentException(WRONG_INPUT_DUPLICATE_MESSAGE);
		}
		return inputNumber;
	}

	public static boolean hasExactLength(String inputNumber) {
		return inputNumber.length() == NUMBER_LENGTH;
	}
	public static boolean hasExactRange(String inputNumber) {
		return inputNumber.chars().allMatch(Character::isDigit);
	}
	public static boolean hasExactDuplicate(String inputNumber) {
		String[] inputNumbers = inputNumber.split("");
		Set<String> setNumbers = Arrays.stream(inputNumbers).collect(Collectors.toSet());

		return setNumbers.size() == NUMBER_LENGTH;
	}
}
