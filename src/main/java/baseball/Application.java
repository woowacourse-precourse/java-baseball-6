package baseball;

import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {

		UserNumber UserNumber = new UserNumber();
		String[] inputUserNumber = UserNumber.inputUserNumber();
		UserNumber.checkInputOnlyNum(inputUserNumber);

		Set<Integer> UserNumberSet = UserNumber.toSetUserNumber(inputUserNumber);
		System.out.println(UserNumberSet);

	}

	//1~9 사이의 서로 다른 3자리로 이루어진 컴퓨터 숫자를 생성하는 메서드
	static Set<Integer> createComputerNumber() {
		Set<Integer> computerNumber = new HashSet<>();
		final int COMPUTER_NUMBER_SIZE = 3;
		final int COMPUTER_MIN_NUMBER = 1;
		final int COMPUTER_MAX_NUMBER = 9;

		while (computerNumber.size() < COMPUTER_NUMBER_SIZE) {
			int randomNumber = Randoms.pickNumberInRange(COMPUTER_MIN_NUMBER, COMPUTER_MAX_NUMBER);
			computerNumber.add(randomNumber);
		}

		return computerNumber;
	}
}

class UserNumber {
	final int COMPUTER_NUMBER_SIZE = 3;
	final int COMPUTER_MIN_NUMBER = 1;
	final int COMPUTER_MAX_NUMBER = 9;

	String[] inputUserNumber() {

		System.out.print("숫자를 입력해주세요 : ");

		return Console.readLine().split(",");
	}

	void checkInputOnlyNum(String[] inputUserNumber) {
		boolean errorTest = false;

		for (int i = 0; i < inputUserNumber.length; i++) {
			String eachUserNumber = inputUserNumber[i].trim();

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

		Set<Integer> UserNumber = new HashSet<>();

		for (String eachUserNumber : inputUserNumber) {
			UserNumber.add(Integer.parseInt(eachUserNumber.trim()));
		}

		return UserNumber;
	}

}