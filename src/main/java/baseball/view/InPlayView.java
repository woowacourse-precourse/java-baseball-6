package baseball.view;

import java.util.List;

public class InPlayView {
	static final int NUM_LENGTH = 3;
	static final String RE_NUM = "1";
	static final String EXIT_NUM = "2";
	static final int STRIKE_IDX = 0;
	static final int BALL_IDX = 1;
	static final String STRIKE = "스트라이크";
	static final String BALL = "볼";

	public void printNoCorrect(List<Integer> StrikeOrBallCnt) {
		int strikeCnt = StrikeOrBallCnt.get(STRIKE_IDX);
		int ballCnt = StrikeOrBallCnt.get(BALL_IDX);

		if (strikeCnt != 0 && ballCnt == 0) {
			System.out.println(strikeCnt + STRIKE);
		}

		if (strikeCnt == 0 && ballCnt != 0) {
			System.out.println(ballCnt + BALL);
		}

		if (strikeCnt != 0 && ballCnt != 0) {
			System.out.println(ballCnt + BALL + " " + strikeCnt + STRIKE);
		}

		if (strikeCnt == 0 && ballCnt == 0) {
			System.out.println("낫싱");
		}
	}

	public void printCorrect() {
		System.out.println(NUM_LENGTH + STRIKE);
		System.out.println(NUM_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 " + RE_NUM + ", 종료하려면 "
			+ EXIT_NUM + "를 입력하세요.");
	}
}
