package woowa.hyunho.number;

import camp.nextstep.edu.missionutils.Console;

public class User {
	String inputNumber;
	
	public void setNumber() {
		inputNumber = Console.readLine();
	}
	
	public String getNumber() {
		return inputNumber;
	}
}