package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

// Model: 게임의 상태와 로직을 관리
public class BaseballGameModel {
	private static final int MAX_RANGE_NUMBER = 9;
	private static final int MIN_RANGE_NUMBER = 1;
	private static final int MAX_SIZE_NUMBER = 3;

	ArrayList<Integer> answerNumberList = new ArrayList<Integer>();

	public static int getMaxSizeNumber() {
		return MAX_SIZE_NUMBER;
	}

	public void createNumber() {
		answerNumberList.clear();
		while (answerNumberList.size() < MAX_SIZE_NUMBER) {
			int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
			if (!answerNumberList.contains(randomNumber)) {
				answerNumberList.add(randomNumber);
			}
		}

	}

	public String compareNumber(int[] guessNumberList) {

		int strikes = 0;
		int balls = 0;

		for (int i = 0; i < MAX_SIZE_NUMBER; i++) {
			for (int j = 0; j < MAX_SIZE_NUMBER; j++) {
				if (guessNumberList[i] == answerNumberList.get(j)) {
					if (i == j) {
						strikes++;
					} else {
						balls++;
					}
				}
			}
		}
		if (strikes == 3) {
			return "3스트라이크";
		} else if (strikes > 0 || balls > 0) {
			String result = "";
			if (balls > 0) {
				result += balls + "볼 ";
			}
			if (strikes > 0) {
				result += strikes + "스트라이크 ";
			}
			return result;
		} else {
			return "낫싱";
		}
	}

}
