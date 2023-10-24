package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.*;

public class Application {

	public static String RESTART = "1";
	public static String THEEND = "2";

	public static void main(String[] args) throws IllegalArgumentException {
		System.out.println("숫자 야구 게임을 시작합니다.");

		String restart = RESTART;
		boolean flag = true;

		while (restart.equals(RESTART)) {
			List<Integer> comNumList = comNumList();
			List<Integer> userNumList = null;

			flag = true;

			while (flag) {
				System.out.print("숫자를 입력해주세요 : ");
				userNumList = userNumList();
				String message = countHit(comNumList, userNumList);

				if (message.equals("3스트라이크")) {
					System.out.println("3스트라이크");
					System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
					System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

					flag = false;
					restart = Console.readLine();

					if (restart.equals(RESTART))
						break;
					else if (restart.equals(THEEND))
						return;
					else
						throw new IllegalArgumentException();
				} else {
					System.out.println(message);
				}
			}
		}
	}

	public static List<Integer> comNumList() {
		List<Integer> comNum = new ArrayList<>();

		while (comNum.size() < 3) {
			int randNum = Randoms.pickNumberInRange(1, 9);

			if (!comNum.contains(randNum)) {
				comNum.add(randNum);
			}
		}

		return comNum;
	}

	public static List<Integer> userNumList() throws IllegalArgumentException {
		String[] userInput = Console.readLine().split("");
		List<Integer> userNum = new ArrayList<>();

		if (userInput.length > 3)
			throw new IllegalArgumentException();

		if (!userNum.isEmpty())
			userNum.removeAll(userNum);

		for (int i = 0; i < 3; i++) {
			userNum.add(Integer.parseInt(userInput[i]));
		}

		return userNum;
	}

	public static int countContain(List<Integer> com, List<Integer> user) {
		int contain = 0;

		for (int i = 0; i < 3; i++) {
			if (com.contains(user.get(i)))
				contain++;
		}

		return contain;
	}

	public static int countStrike(List<Integer> com, List<Integer> user) {
		int strike = 0;

		for (int i = 0; i < 3; i++) {
			if (com.get(i) == user.get(i))
				strike++;
		}

		return strike;
	}

	public static String countHit(List<Integer> com, List<Integer> user) throws IllegalArgumentException {
		int contain = countContain(com, user);
		int strike = countStrike(com, user);
		int ball = contain - strike;

		if (contain == 0) {
			return "낫싱";
		} else if (ball == 0) {
			return strike + "스트라이크";
		} else if (strike == 0) {
			return ball + "볼";
		} else if (ball < 3 && strike < 3) {
			return ball + "볼 " + strike + "스트라이크";
		} else
			throw new IllegalArgumentException();
	}
}
