package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

// 컴퓨터 랜덤 세자리 숫자 추출
public class ComputerNum {
	private List<Integer> computer;
		
	public ComputerNum() {
		this.computer = new ArrayList<>();
	}
	
	public void setNumber() {
		while (this.computer.size() < 3) {
    	    int randomNumber = Randoms.pickNumberInRange(1, 9);
    	    if (!this.computer.contains(randomNumber)) {
    	    	this.computer.add(randomNumber);
    	    }
    	}
	}
	
	public List<Integer> getNumber(){
		return this.computer;
	}
}
