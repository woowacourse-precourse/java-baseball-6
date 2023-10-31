package woowa.hyunho.handler;

import camp.nextstep.edu.missionutils.Console;

public class Selector {
	String selectorNumber;
	
	public String selectorNumberHandler() {
		try {
			selectorNumber = Console.readLine();
			Rule.checkSelectorNumber(selectorNumber);
			return selectorNumber;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("유효한 정수가 아닙니다.");
		}
	}
}