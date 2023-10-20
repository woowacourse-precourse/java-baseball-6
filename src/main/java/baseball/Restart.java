package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Restart {
	public boolean restart() {

		String choice = "";
		while (!choice.equals("1") && !choice.equals("2")) {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			choice = Console.readLine();
		}
		System.out.println("1, 2만 입력 가능합니다. 다시 입력해주세요.");

		if ("2".equals(choice)) {
			System.out.println("게임 종료");
			return false;
		} else
			return true;
	}

}
