package baseball;

import java.util.List;

public class HintGenerator {
    private static final int SIZE = 3;
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String SPACE = " ";

    public String getHint(List<Integer> computerNumber, List<Integer> playerNumber) { // 볼 or 스트라이크 or 낫싱 결과 계산
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (computerNumber.get(i) == playerNumber.get(j) && i == j) {
                    strikeCount++;
                }
                if (computerNumber.get(i) == playerNumber.get(j) && i != j) {
                    ballCount++;
                }
            }
        }
        return makeHintText(strikeCount, ballCount);
    }

    private String makeHintText(int strikeCount, int ballCount) { // 볼, 스트라이크 횟수에 따라 힌트 메시지 생성
        StringBuilder sb = new StringBuilder();
        if (ballCount > 0) {
            sb.append(ballCount);
            sb.append(BALL);
        }
        if (ballCount > 0 && strikeCount > 0) {
            sb.append(SPACE);
        }
        if (strikeCount > 0) {
            sb.append(strikeCount);
            sb.append(STRIKE);
        }
        if (ballCount == 0 && strikeCount == 0) {
            sb.append(NOTHING);
        }
        return sb.toString();
    }
}