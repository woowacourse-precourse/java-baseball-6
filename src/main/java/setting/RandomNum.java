package setting;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNum {

	private List<Integer> answerNum = new ArrayList<>();
	private String strAnswer = "";

	public String setRandomNum() {
		while (answerNum.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!answerNum.contains(randomNumber)) {
				answerNum.add(randomNumber);
				strAnswer += randomNumber;
			}
		}
		return strAnswer;
	}
}