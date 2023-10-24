package baseball.service;

import java.util.ArrayList;
import java.util.List;

public class CalculateService {
	private static final int NUM_LENGTH = 3;
	private int strikeCnt;
	private int ballCnt;
	private final List<Integer> StrikeOrBallCountList = new ArrayList<>();

	public List<Integer> calculateNumber(List<Integer> computerNumber, List<Integer> userNumber) {
		resetCount();
		setStrikeAndBallCnt(countStrike(computerNumber, userNumber), countBall(computerNumber, userNumber));
		return StrikeOrBallCountList;
	}

	public int countStrike(List<Integer> computerNumber, List<Integer> userNumber) {
		for (int i = 0; i < NUM_LENGTH; i++) {
			if (isStrike(computerNumber, userNumber, i)) {
				strikeCnt++;
			}
		}

		return strikeCnt;
	}

	public int countBall(List<Integer> computerNumber, List<Integer> userNumber) {
		for (int i = 0; i < NUM_LENGTH; i++) {
			if (computerNumber.contains(userNumber.get(i)) && !isStrike(computerNumber, userNumber, i)) {
				ballCnt++;
			}
		}

		return ballCnt;
	}

	public boolean isStrike(List<Integer> computerNumber, List<Integer> userNumber, int loopIdx) {
		if (computerNumber.get(loopIdx) == userNumber.get(loopIdx)) {
			return true;
		}
		return false;
	}

	public void setStrikeAndBallCnt(int strike, int ball) {
		StrikeOrBallCountList.add(strike);
		StrikeOrBallCountList.add(ball);
	}

	public void resetCount() {
		StrikeOrBallCountList.clear();
		strikeCnt = 0;
		ballCnt = 0;
	}
}