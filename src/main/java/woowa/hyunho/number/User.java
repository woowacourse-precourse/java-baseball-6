package woowa.hyunho.number;

import woowa.hyunho.handler.Random;

public class User {
	String randomNumber;
	
	public void setNumber() {
		Random random = new Random();
		randomNumber = random.randomNumberHandler();
	}
	
	public String getNumber() {
		return randomNumber;
	}
}