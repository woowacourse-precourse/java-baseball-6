package woowa.hyunho.number;

import java.util.List;
import woowa.hyunho.handler.Random;
import woowa.hyunho.utilities.Parse;

public class User {
	String randomNumber;
	
	public List<Integer> generateUserNumberList() {
		Random random = new Random();
		randomNumber = random.randomNumberHandler();
		return Parse.parseStringToIntList(randomNumber);
	}
}