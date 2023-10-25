package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

	public List<Integer> randomcomputerNum(){
		List<Integer> computer = new ArrayList<>();
		while (computer.size() < 3) {
		    int randomNumber = Randoms.pickNumberInRange(1, 9);
		    if (!computer.contains(randomNumber)) {
		        computer.add(randomNumber);
		    }
		}
		return computer;
	}
}
