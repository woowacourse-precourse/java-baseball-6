package baseball;

import java.util.List;

public class BaseballGameResult {

	public int baseballGameResult(int numberIsRight, int[] countScore) {

		int ballCount = countScore[0];
		int strikeCount = countScore[1];

		if (strikeCount == 0 && ballCount == 0) {
			System.out.println("낫싱\n");
		} else if (strikeCount > 0 && ballCount == 0) {
			if (strikeCount == 3) {
				System.out.printf("%d스트라이크\n", strikeCount);
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				numberIsRight = 0;
			} else {
				System.out.printf("%d스트라이크\n", strikeCount);
			}
		} else if (strikeCount == 0 && ballCount > 0) {
			System.out.printf("%d볼\n", ballCount);
		} else {
			System.out.printf("%d볼 %d스트라이크\n", ballCount, strikeCount);
		}

		return numberIsRight;
	}

	public int[] countScore(List<Integer> computerNumberList,
	                        List<Integer> userNumberList) {

		int ballCnt = 0;
		int strikeCnt = 0;
		int[] resultScore = new int[2];

		for (int i = 0; i < computerNumberList.size(); i++) {
			for (int j = 0; j < userNumberList.size(); j++) {
				if (computerNumberList.get(i).equals(userNumberList.get(j))) {
					if (i != j) {
						ballCnt++;
					} else {
						strikeCnt++;
					}
				}
			}
		}
		resultScore[0] = ballCnt;
		resultScore[1] = strikeCnt;

		return resultScore;
	}
}
