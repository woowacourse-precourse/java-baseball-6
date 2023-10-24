package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	public List<Integer> RandomComputerNum() {
	  List<Integer> computerNum = new ArrayList<>();
	
	   while (computerNum.size() < 3) {
		int randomNumber = Randoms.pickNumberInRange(1, 9);
		if (!computerNum.contains(randomNumber)) {
	     computerNum.add(randomNumber);
	    }
	  }
	   
	return computerNum;
	}
}
