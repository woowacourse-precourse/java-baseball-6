package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class UserNumberMaker {

	final int USER_NUMBER_SIZE = 3;
	final int USER_MIN_NUMBER = 1;
	final int USER_MAX_NUMBER = 9;

	String[] inputUserNumber() {

		System.out.print("숫자를 입력해주세요 : ");

		return Console.readLine().split("");
	}

	void checkInputOnlyNum(String[] inputUserNumber) {

		boolean errorTest = false;

		for (String eachUserNumber : inputUserNumber) {
			try {
				Integer.parseInt(eachUserNumber);
			} catch (IllegalArgumentException ill) {
				errorTest = true;
			}

			if (errorTest) {
				throw new IllegalArgumentException("숫자만 입력해주세요.");
			}
		}
	}

	void checkInputSize(String[] inputUserNumber) {

		if (inputUserNumber.length != USER_NUMBER_SIZE) {
			throw new IllegalArgumentException(USER_NUMBER_SIZE + "자리 숫자만 입력해주세요.");
		}
	}

	List<Integer> toListUserNumber(String[] inputUserNumber) {

		List<Integer> userNumber = new ArrayList<>();

		for (String eachUserNumber : inputUserNumber) {
			int eachUserNumberList = Integer.parseInt(eachUserNumber);
			if (!userNumber.contains(eachUserNumberList)) {
				userNumber.add(eachUserNumberList);
			}
		}

		return userNumber;
	}

	void checkDuplicationUserNum(List<Integer> userNumber) {

		if (userNumber.size() != USER_NUMBER_SIZE) {
			throw new IllegalArgumentException("중복되지 않는 " + USER_NUMBER_SIZE + "자리 숫자만 입력해주세요");
		}
	}

	void checkRangeUserNum(List<Integer> userNumber) {

		for (Integer eachUserNumber : userNumber) {
			if (!(USER_MIN_NUMBER <= eachUserNumber && eachUserNumber <= USER_MAX_NUMBER)) {
				throw new IllegalArgumentException(USER_MIN_NUMBER + "~" + USER_MAX_NUMBER + " 사이의 숫자만 입력해주세요");
			}
		}
	}

}
