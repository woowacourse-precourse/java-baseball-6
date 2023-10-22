package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {
		List<Integer> answerNum = new ArrayList<>();
		while (answerNum.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!answerNum.contains(randomNumber)) {
				answerNum.add(randomNumber);
			}
		}
		System.out.println(answerNum);
	}
}
