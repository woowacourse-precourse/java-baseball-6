package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	
	public static String inputPlayerNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		return ExceptionCheck.playerNumberCheck(Console.readLine());
	}

}
