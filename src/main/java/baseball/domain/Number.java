package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public class Number {
	private final int SIZE = 3;
	private String number;

	public Number(String number) {
		validateSize(number);
		validateDuplication(number);
		this.number = number;
	}

	private void validateSize(String number) {
		if(number.length()!=SIZE) {
			throw new IllegalArgumentException(SIZE+"자리수의 숫자를 입력해주세요.");
		}
	}

	private void validateDuplication(String number) {
		Map<Character, Integer> checkMap = new HashMap<>();

		for(char checkNumber : number.toCharArray()) {
			initCheckMap(checkMap, checkNumber);
			checkDuplication(checkMap, checkNumber);
		}
	}

	private void initCheckMap(Map<Character, Integer> checkMap, char checkNumber) {
		int checkNumberCount = checkMap.getOrDefault(checkNumber, 0);
		checkMap.put(checkNumber, checkNumberCount + 1);
	}

	private void checkDuplication(Map<Character, Integer> checkMap, char checkNumber) {
		if(isDuplicated(checkMap, checkNumber)) {
			throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
		}
	}

	private boolean isDuplicated(Map<Character, Integer> checkMap, char checkNumber) {
		return checkMap.get(checkNumber) > 1;
	}
}
