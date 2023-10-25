package baseball;

import java.util.List;

public class CalculateResult {
    private int strikeCount = 0;
    private int ballCount = 0;

    // 컴퓨터 숫자와 플레이어 숫자를 비교하여 결과 도출
    public CalculateResult(List<Integer> computerBall, List<Integer> playerBall) {
        for (int i = 0; i < playerBall.size(); i++) {
            int value = playerBall.get(i);
            countBall(computerBall, value, i);
        }
    }

    // 두 리스트를 비교해서 strike와 ball의 개수를 세는 메서드
    private void countBall(List<Integer> computerBall, int value, int i) {
        if (computerBall.contains(value) && computerBall.indexOf(value) != i) {
            this.ballCount += 1;
        }
        if (computerBall.contains(value) && computerBall.indexOf(value) == i) {
            this.strikeCount += 1;
        }
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public int getBallCount() {
        return this.ballCount;
    }
}
