package woowa.hyunho.handler;

import camp.nextstep.edu.missionutils.Console;

public class Random {
	String randomNumber;
	
	public String randomNumberHandler() {
		try {
			randomNumber = Console.readLine();
			Rule.checkRandomNumber(randomNumber);
			return randomNumber;
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException("유효한 정수가 아닙니다.");
		}
	}
}