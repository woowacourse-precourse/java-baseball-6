package woowa.hyunho.number;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	List<Integer> computerRandomNumber;
	
	public void generateRandomNumber() {
		computerRandomNumber = new ArrayList<>();
		while (computerRandomNumber.size() < 3) {
			int randomNumber = generateNumber();
			addNumber(randomNumber);
		}
		System.out.println(computerRandomNumber);
	}
	
	private int generateNumber() {
		return Randoms.pickNumberInRange(1,9);
	}
	
	private void addNumber(int n) {
		if (!computerRandomNumber.contains(n))
			computerRandomNumber.add(n);
	}
	
	public List<Integer> getRandomNumber() {
		return computerRandomNumber;
	}
}