package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class createNumber {

	public String getRandomNumber(){
		StringBuilder result = new StringBuilder();

		List<Integer> computer = new ArrayList<>();
		while (computer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}

		for(int number : computer){
			result.append(String.valueOf(number));
		}

		return result.toString();
	}
}
