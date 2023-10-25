package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}
	
	class ComputerNum {
	    List<Integer> computerNum;

	    public ComputerNum() {
	        computerNum = pickRandomNum();
	    }

	    private List<Integer> pickRandomNum() {
	        List<Integer> numList = new ArrayList<>();
	        
	        while(numList.size() <3) {
	        	int newNum = Randoms.pickNumberInRange(1, 9);
	        	if(numList.contains(newNum)) continue;
	        	numList.add(newNum);
	        }
	        return numList;
	    }
	}
}


