package baseballgame;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballNumberset {
	 private static final int NUM_DIGITS = 3;
	    private List<Integer> computerNumbers;
	    
	    public BaseballNumberset() {
	    	generateComputerNumbers();
	    }
	    
	    public void generateComputerNumbers() {
	        computerNumbers = new ArrayList<>();
	        while (computerNumbers.size() < NUM_DIGITS) {
	            int num = Randoms.pickNumberInRange(1, 9);
	            if (!computerNumbers.contains(num)) {
	                computerNumbers.add(num);
	            }
	        }
	    }
	    
	    
	    public List<Integer> getNumbers(){
	    	return computerNumbers;
	    }

}
