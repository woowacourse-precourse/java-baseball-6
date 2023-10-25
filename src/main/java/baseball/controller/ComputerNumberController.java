package baseball.controller;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumberController {
	
	private int startNumberRange = 1;
	private int endNumberRange = 9;
	
	public List<Integer> madeComputerNumber(){
		
		List<Integer> computerNumber = new ArrayList<Integer>();
		while(computerNumber.size()<3) {
			_madeComputerNumber(computerNumber);
		}
		return computerNumber;
	}
	
	private void _madeComputerNumber(List<Integer> computerNumber) {
		int randomNumber = madeRandomNumber();
		if(!isDuplicationNumber(computerNumber,randomNumber)) {
			computerNumber.add(randomNumber);
		}
	}
	
	private boolean isDuplicationNumber(List<Integer>computerNumber, int randomNumber) {
		return computerNumber.contains(randomNumber);
	}
	
	private int madeRandomNumber() {
		
		return Randoms.pickNumberInRange(startNumberRange, endNumberRange);
	}
	
	
}
