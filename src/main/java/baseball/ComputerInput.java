package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerInput {
	
	private List<Integer> computer = new ArrayList<Integer>();
	
	public ComputerInput() {
		
	}
	
	public List<Integer> getComputer(){
		while (computer.size() < 3) { //컴퓨터 랜덤 숫자 입력
    	    int randomNumber = Randoms.pickNumberInRange(1, 9);
    	    if (!computer.contains(randomNumber)) {
    	        computer.add(randomNumber);
    	    }
    	}
		
		return computer;
	}

}
