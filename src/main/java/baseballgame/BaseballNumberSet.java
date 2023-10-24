package baseballgame;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballNumberSet {
	 private static final int NUM_DIGITS = 3;
	 private List<Integer> computerNumbers;
	    
	 public BaseballNumberSet() {
	    	generateComputerNumbers();
	    }
	 
	 // 컴퓨터의 숫자를 랜덤으로 배정하는 메서드
	 public void generateComputerNumbers() {
	      computerNumbers = new ArrayList<>();
	      while (computerNumbers.size() < NUM_DIGITS) {
	           int num = Randoms.pickNumberInRange(1, 9);
	           if (!computerNumbers.contains(num)) {
	                computerNumbers.add(num);
	            }
	        }
	    }
	    
	 
	    // 배정된 컴퓨터의 숫자를 반환하는 메서드
	    public List<Integer> getNumbers() {
	    	return computerNumbers;
	    }

}
