package setting;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNum {
	
	private List<Integer> answerNum = new ArrayList<>();
	
	public RandomNum() {
		getRandomNum();
	}
	
	public void setRandomNum() {
		//
	}
	
	public List<Integer> getRandomNum() {
		while (answerNum.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!answerNum.contains(randomNumber)) {
				answerNum.add(randomNumber);
			}
		}
		System.out.println(answerNum);
		return answerNum;
		
	}
	

	
}