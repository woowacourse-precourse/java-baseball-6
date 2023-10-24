package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
	
	/* maxNum만큼의 숫자 뽑기 메소드 */
	public List<Integer> generate(int maxNum) {
		List<Integer> numbers = new ArrayList<Integer>();
    	
		// 서로 다른 세 자리 수 뽑기
    	while (numbers.size() < maxNum) {
    		int ranNum = Randoms.pickNumberInRange(1, 9);
    		
    		// 이미 있는 숫자가 아니면 추가
    		if(!numbers.contains(ranNum)) numbers.add(ranNum);
    	}
    	
    	return numbers;
	}
}