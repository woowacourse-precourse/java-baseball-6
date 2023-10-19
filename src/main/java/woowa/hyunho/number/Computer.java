package woowa.hyunho.number;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	List<Integer> computer;
	
	public void generateRandomNumber() {
		computer = new ArrayList<>();
		while (computer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1,9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}
	}
	
	public List<Integer> getRandomNumber() {
		return computer;
	}
}