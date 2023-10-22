package baseball;

import java.util.List;

public class HintGenerator {
    private static final int SIZE = 3;

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
            sb.append("볼");
        }
        if (ballCount > 0 && strikeCount > 0) {
            sb.append(" ");
        }
        if (strikeCount > 0) {
            sb.append(strikeCount);
            sb.append("스트라이크");
        }
        if (ballCount == 0 && strikeCount == 0) {
            sb.append("낫싱");
        }
        return sb.toString();
    }
}
