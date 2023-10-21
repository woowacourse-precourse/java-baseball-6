package util;
import camp.nextstep.edu.missionutils.*;
import java.util.*;

public class RandomThreeNumber {
	//서로 다른 세자리 수 생성
	public static String getRandomNumber() {
		Set<Integer> set = new HashSet<>();
		while(set.size()<3) {
			int temp = Randoms.pickNumberInRange(1, 9);
			set.add(temp);			
		}
		StringBuilder sb = new StringBuilder();
		for(int i : set) sb.append(i);
		return sb.toString();
	}
	
}
