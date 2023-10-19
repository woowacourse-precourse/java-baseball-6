package baseball;

import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {

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
