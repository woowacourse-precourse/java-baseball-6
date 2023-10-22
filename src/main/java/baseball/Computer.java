package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
	
	public List<Integer> computerNumber;
	
	public Computer() {
		computerNumber = new ArrayList<>();
	}
	
	public void setComputerNumber() {	
		while (computerNumber.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computerNumber.contains(randomNumber)) {
				computerNumber.add(randomNumber);
			}
		}
	}

}
