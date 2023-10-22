package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public class Number {
	private String number;

	public Number(String number, int size) {
		validateSize(number, size);
		validateDuplication(number);
		this.number = number;
	}

	protected String getNumber() {
		return number;
	}

	private void validateSize(String number, int size) {
		if(number.length()!=size) {
			throw new IllegalArgumentException(size+"자리수의 숫자를 입력해주세요.");
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
