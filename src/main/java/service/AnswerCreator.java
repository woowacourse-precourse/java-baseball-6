package service;

import camp.nextstep.edu.missionutils.Randoms;

public class AnswerCreator {
	private final Validator validator;
	public AnswerCreator(Validator validator) {
		this.validator = validator;
	}

	public int createAnswer() {
		int answerNumber = 0;
		int multiplyNumber = 100;
		for (int i = 0; i < 3; i++) {
			answerNumber += Randoms.pickNumberInRange(1, 9)*multiplyNumber;
			multiplyNumber /= 10;
		}
		if (!validator.checkDuplication(answerNumber)) {
			answerNumber = createAnswer();
		}
		return answerNumber;
	}

}
