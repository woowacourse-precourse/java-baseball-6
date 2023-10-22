package baseball.domain;

import static baseball.controller.GameController.NUMBER_SIZE;

import java.util.HashMap;
import java.util.Map;

public class Number {
	private String number;

	public Number(String number) {
		validateRange(number);
		validateSize(number, NUMBER_SIZE);
		validateDuplication(number);
		this.number = number;
	}

	protected String getNumber() {
		return number;
	}

	private void validateRange(String number) {
		for(char c : number.toCharArray()) {
			if(c - '0' < 1 || c - '0' > 9) {
				throw new IllegalArgumentException("숫자가 주어진 범위에서 벗어납니다.");
			}
		}
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
