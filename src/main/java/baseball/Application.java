package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {

		BaseballGame play = new BaseballGame();

		System.out.println("숫자 야구 게임을 시작합니다.");

		List<Integer> computer = play.ComputerNum();
		while (true) {
			System.out.print("숫자를 입력해주세요 : ");
			int player = Integer.parseInt(Console.readLine());
			System.out.println(player);
			try {
				if (play.Check(player)) {
					List<Integer> userInput = getUserInput(player);
					String result = play.Result(computer, userInput);

					if (result.equals("3스트라이크")) {
						System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
						System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
						int collect = Integer.parseInt(Console.readLine());
						if (collect == 2) {
							break;
						} else {
							throw new IllegalArgumentException();
						}
					} else {
						System.out.println(result);

					}

				}

			} catch (IllegalArgumentException e) {
				throw e;
			}
		}
	}

	public static List<Integer> getUserInput(int player) {
		List<Integer> userInput = new ArrayList<>();
		while (player > 0) {
			userInput.add(player % 10);
			player /= 10;
		}
		Collections.reverse(userInput);
		return userInput;
	}
}