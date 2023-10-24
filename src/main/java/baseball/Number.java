package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {
	String number;
	Integer length = 3;        // 숫자 길이

	// 컴퓨터 숫자
	public Number() {
		this.number = generateRandomNumber();
	}

	// 인풋 숫자
	public Number(String input) {
		this.number = input;
		validateInputNumber(input);
	}

	// 1에서 9까지 서로 다른 임의의 수 3개를 선택하여 문자열로 반환합니다.
	private String generateRandomNumber() {
		String str = "";
		str += Randoms.pickNumberInRange(1, 9);
		while (str.length() != length) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!str.contains(String.valueOf(randomNumber))) {
				str += randomNumber;
			}
		}
		return str;
	}

	// 입력값이 유효한지 검증합니다.
	private void validateInputNumber(String inputNumber) {
		char[] arr = inputNumber.toCharArray();
		if (arr.length != length) {
			throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
		}
		if (arr[0] == arr[1] || arr[1] == arr[2] || arr[2] == arr[0]) {
			throw new IllegalArgumentException("서로 다른 임의의 수 3개를 입력해야 합니다.");
		}
		if (!('1' <= arr[0] && arr[0] <= '9') ||
				!('1' <= arr[1] && arr[1] <= '9') ||
				!('1' <= arr[2] && arr[2] <= '9')) {
			throw new IllegalArgumentException("숫자를 입력해야 합니다.");
		}
	}

}
