package baseball;

import camp.nextstep.edu.missionutils.*;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.stream.Collectors;

public class Application {
	private static List<Integer> computer = new ArrayList<>();
	
    public static void main (String[] args){
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	RandomNumbers();
    	for (int i = 0; i < 3; i++) {
    		System.out.println(computer.get(i));
		}
    }
    
	public static List<Integer> RandomNumbers() {
		while(computer.size()<3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if(!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
    	}
		return computer;
	}
	
	
    
}