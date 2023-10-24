package baseball.domain.model;

import baseball.global.util.enums.NumberRangeEnum;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Game {

	private int ballCnt = 0;
	private int strikeCnt = 0;

	public Game(LinkedHashSet<Integer> answerNumberSet, List<Integer> expectedNumberList) {
		calcBallCnt(answerNumberSet, expectedNumberList);
		calcStrikeCnt(answerNumberSet, expectedNumberList);
	}

	private void calcBallCnt(LinkedHashSet<Integer> answerNumberSet, List<Integer> expectedNumberList) {
		List<Integer> answerNumberList = new ArrayList<>(answerNumberSet);
		for (int i=0; i<NumberRangeEnum.NUMBER_LENGTH.getValue(); i++){
			if (answerNumberSet.contains(expectedNumberList.get(i)) && !answerNumberList.get(i).equals(expectedNumberList.get(i))){
				ballCnt++;
			}
		}
	}

	private void calcStrikeCnt(LinkedHashSet<Integer> answerNumberSet, List<Integer> expectedNumberList) {
		List<Integer> answerNumberList = new ArrayList<>(answerNumberSet);
		for (int i=0; i<NumberRangeEnum.NUMBER_LENGTH.getValue(); i++){
			if (answerNumberList.get(i).equals(expectedNumberList.get(i))){
				strikeCnt++;
			}
		}
	}

	public boolean isClear() {
		return strikeCnt == NumberRangeEnum.NUMBER_LENGTH.getValue();
	}

	public int getBallCnt() {
		return ballCnt;
	}

	public int getStrikeCnt() {
		return strikeCnt;
	}
}
