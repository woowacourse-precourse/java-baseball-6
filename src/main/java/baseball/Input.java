package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	
	public static String inputPlayerNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		return ExceptionCheck.playerNumberCheck(Console.readLine());
	}
	
	public static boolean newGameSelect() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return ExceptionCheck.playerSelectCheck(Integer.parseInt(Console.readLine()));
	}
}
