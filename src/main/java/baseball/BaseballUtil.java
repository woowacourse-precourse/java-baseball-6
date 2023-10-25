package baseball;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class BaseballUtil {
	public static List<Integer> makeObjectNumber() { 
		int numberOfDigits = 3;
		List<Integer> computer = new ArrayList<>();
		while (computer.size() < numberOfDigits) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}
		return computer;
	}

	public static LinkedList<Integer> getInputNumber() { 

		System.out.print("숫자를 입력해주세요 : ");

		String inputNumbers = Console.readLine();

		inputNumberCheck(inputNumbers); // 세 자리 숫자인지 체크하는 함수 호출

		int userNumbers = Integer.parseInt(inputNumbers);
		LinkedList<Integer> userNumberList = new LinkedList<Integer>();
		userNumberList.clear();
		while (userNumbers > 0) {
			userNumberList.push(userNumbers % 10);
			userNumbers = userNumbers / 10;
		}
		return userNumberList;
	}

	public static void comparingNumber() {
		List<Integer> computer = makeObjectNumber();
		LinkedList<Integer> userNumberList;
		int strike = 0;
		int ball = 0;

		while (strike != 3) {
			strike = 0;
			ball = 0;
			userNumberList = getInputNumber();

			for (int i = 0; i < 3; i++) {
				if (computer.contains(userNumberList.get(i))) {
					if (computer.get(i) == userNumberList.get(i)) {
						strike++;
					} else {
						ball++;
					}
				}
			}
			printResult(strike, ball);
		}
	}

	public static void printResult(int strike, int ball) { 
		if (strike == 0 && ball == 0) {
			System.out.println("낫싱");
		} else if (strike == 0) {
			System.out.println(ball + "볼");
		} else if (strike == 3) {
			System.out.println(strike + "스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			checkMoreGame();
		} else if (ball == 0) {
			System.out.println(strike + "스트라이크");
		} else {
			System.out.println(ball + "볼 " + strike + "스트라이크 ");
		}
	}

	public static void checkMoreGame() { // 게임 재시작 혹은 종료 여부를 묻는다.

		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String asking = Console.readLine();
		if (asking.equals("1")) {
			comparingNumber();
		} else if (asking.equals("2")) {
			System.out.println("게임을 종료합니다");
			return; // 애플리케이션 종료
		} else {
			throw new IllegalArgumentException();
		}
	}

	public static boolean inputNumberCheck(String str) {

		int n = str.length();

		if (n != 3 || isOnlyDigits(str, n) == false || isDiffNumber(str) == false) { // 세 자리인지, 숫자로만 구성 되었는지, 서로 다른 숫자인지 체크
			throw new IllegalArgumentException();
		} else {
			return true;
		}
	}

	public static boolean isOnlyDigits(String str, int n) {
		for (int i = 0; i < n; i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isDiffNumber(String str) {
		int n = str.length();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (str.charAt(i) == str.charAt(j)) {
					cnt++;
				}
			}
		}
		if (cnt > n) {
			return false;
		}
		return true;
	}

}
