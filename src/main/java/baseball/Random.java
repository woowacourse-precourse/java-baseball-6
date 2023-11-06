package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {
	public static ArrayList<Integer> Computer(){
		ArrayList<Integer> arr = new ArrayList<>();
		while(arr.size() < 3) {
			int random = Randoms.pickNumberInRange(1, 9);
			if(!arr.contains(random)) {
				arr.add(random);
			}
		}
		return arr;
	}
}
