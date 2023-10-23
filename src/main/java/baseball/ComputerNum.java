package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNum {
	private List<Integer> computer;
		
	public ComputerNum() {
		this.computer = new ArrayList<>();
    	while (computer.size() < 3) {
    	    int randomNumber = Randoms.pickNumberInRange(1, 9);
    	    if (!computer.contains(randomNumber)) {
    	        computer.add(randomNumber);
    	    }
    	}
	}
	
	public List<Integer> getNumber(){
		return this.computer;
	}
}
