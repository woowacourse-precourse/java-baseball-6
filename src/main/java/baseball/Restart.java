package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Restart {
	private static final String OUTPUT_RESTART_OR_QUIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ";
	private static final String OUTPUT_QUIT = "게임 종료";

	public boolean restart() {

		System.out.println(OUTPUT_RESTART_OR_QUIT);
		String choice = Console.readLine();
		if (choice.equals("1")) {
			return true;
		}
		if (choice.equals("2")) {
			System.out.println(OUTPUT_QUIT);
			return false;
		}
		throw new IllegalArgumentException();

	}

}
