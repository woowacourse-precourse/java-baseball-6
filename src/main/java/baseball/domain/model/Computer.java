package baseball.domain.model;

import baseball.global.util.enums.NumberRangeEnum;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;

public class Computer {
	private LinkedHashSet<Integer> answerNumberSet;

	public void generateAnswerNumber() {
		answerNumberSet = new LinkedHashSet<>();

		while (answerNumberSet.size() < NumberRangeEnum.NUMBER_LENGTH.getValue()) {
			int randomNumber = Randoms.pickNumberInRange(NumberRangeEnum.MIN_NUMBER.getValue(), NumberRangeEnum.MAX_NUMBER.getValue());
			answerNumberSet.add(randomNumber);
		}
	}

	public LinkedHashSet<Integer> getAnswerNumberSet() {
		return answerNumberSet;
	}
}
