package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {

		UserNumber UserNumber = new UserNumber();
		String[] inputUserNumber = UserNumber.inputUserNumber();
		UserNumber.checkInputOnlyNum(inputUserNumber);

		Set<Integer> UserNumberSet = UserNumber.toSetUserNumber(inputUserNumber);
		UserNumber.checkSizeUserNum(UserNumberSet);
		UserNumber.checkRangeUserNum(UserNumberSet);

		List<Integer> computerNumber = List.of(7, 1, 3);

		int ballNumber = countBall(computerNumber, UserNumberSet);

		System.out.println(ballNumber);

	}

	//1~9 사이의 서로 다른 3자리로 이루어진 컴퓨터 숫자를 생성하는 메서드
	static List<Integer> createComputerNumber() {
		List<Integer> computerNumber = new ArrayList<>();
		final int COMPUTER_NUMBER_SIZE = 3;
		final int COMPUTER_MIN_NUMBER = 1;
		final int COMPUTER_MAX_NUMBER = 9;

		while (computerNumber.size() < COMPUTER_NUMBER_SIZE) {
			int randomNumber = Randoms.pickNumberInRange(COMPUTER_MIN_NUMBER, COMPUTER_MAX_NUMBER);

			if (!computerNumber.contains(randomNumber)) {
				computerNumber.add(randomNumber);
			}
		}

		return computerNumber;
	}

	static int countBall(List<Integer> computerNumber, Set<Integer> userNumber) {
		int ballNumber = 0;

		for (int eachUserNumber : userNumber) {
			if (computerNumber.contains(eachUserNumber)) {
				ballNumber++;
			}
		}

		return ballNumber;
	}

}

class UserNumber {
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
				throw new IllegalArgumentException("숫자만 입력해주세요");
			}

		}
	}

	Set<Integer> toSetUserNumber(String[] inputUserNumber) {

		Set<Integer> userNumber = new HashSet<>();

		for (String eachUserNumber : inputUserNumber) {
			userNumber.add(Integer.parseInt(eachUserNumber));
		}

		return userNumber;
	}

	void checkSizeUserNum(Set<Integer> userNumber) {
		if (userNumber.size() != USER_NUMBER_SIZE) {
			throw new IllegalArgumentException("중복되지 않는 3자리 숫자만 입력해주세요");
		}
	}

	void checkRangeUserNum(Set<Integer> userNumber) {
		for (Integer eachUserNumber : userNumber) {
			if (!(USER_MIN_NUMBER <= eachUserNumber && eachUserNumber <= USER_MAX_NUMBER)) {
				throw new IllegalArgumentException("1~9 사이의 숫자만 입력해주세요");
			}
		}
	}

}