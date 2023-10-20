package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Restart {
	public boolean restart() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String choice = Console.readLine();

		if (choice != "1" && choice != "2") {
			throw new IllegalArgumentException();
		}

		if ("2".equals(choice)) {
			System.out.println("게임 종료");
			return false;
		} else
			return true;
	}

}
