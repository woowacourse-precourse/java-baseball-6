package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {

		List<Integer> computerNumber = List.of(7, 1, 3);

		UserNumber UserNumber = new UserNumber();

		int strikeNumber = 0;

		while (strikeNumber != 3) {
			String[] inputUserNumber = UserNumber.inputUserNumber();
			UserNumber.checkInputOnlyNum(inputUserNumber);

			List<Integer> UserNumberList = UserNumber.toListUserNumber(inputUserNumber);
			UserNumber.checkSizeUserNum(UserNumberList);
			UserNumber.checkRangeUserNum(UserNumberList);

			int ballNumber;

			ballNumber = countBall(computerNumber, UserNumberList);
			strikeNumber = countStrike(computerNumber, UserNumberList);

			printStrike(ballNumber, strikeNumber);
		}

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

	static int countBall(List<Integer> computerNumber, List<Integer> userNumber) {
		int ballNumber = 0;

		for (int eachUserNumber : userNumber) {
			if (computerNumber.contains(eachUserNumber)) {
				ballNumber++;
			}
		}

		return ballNumber;
	}

	static int countStrike(List<Integer> computerNumber, List<Integer> userNumber) {
		int strikeNumber = 0;

		for (int i = 0; i < userNumber.size(); i++) {
			if (computerNumber.get(i).equals(userNumber.get(i))) {
				strikeNumber++;
			}
		}

		return strikeNumber;
	}

	static void printStrike(int ballNumber, int StrikeNumber) {

		if(ballNumber == 0) {
			System.out.println("낫싱");
		}else if (StrikeNumber == 0) {
			System.out.println(ballNumber + "볼");
		}else if (StrikeNumber == ballNumber) {
			System.out.println(StrikeNumber + "스트라이크");
		}else if(StrikeNumber < ballNumber){
			System.out.println((ballNumber - StrikeNumber) + "볼 " + StrikeNumber + "스트라이크");
		}

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

	void checkSizeUserNum(List<Integer> userNumber) {

		if (userNumber.size() != USER_NUMBER_SIZE) {
			throw new IllegalArgumentException("중복되지 않는 3자리 숫자만 입력해주세요");
		}
	}

	void checkRangeUserNum(List<Integer> userNumber) {
		for (Integer eachUserNumber : userNumber) {
			if (!(USER_MIN_NUMBER <= eachUserNumber && eachUserNumber <= USER_MAX_NUMBER)) {
				throw new IllegalArgumentException("1~9 사이의 숫자만 입력해주세요");
			}
		}
	}

}