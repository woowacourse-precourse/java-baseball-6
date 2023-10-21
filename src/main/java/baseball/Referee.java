package baseball;

import java.util.List;

public class Referee {

    BallCount ballCount;

    Referee() {
        ballCount = new BallCount();
    }

    public BallCount checkBallCount(List<Integer> playerBall, List<Integer> computerBall) {
        for (int i = 0; i < playerBall.size(); i++) {
            int num = playerBall.get(i);
            if (computerBall.contains(num)) {
                // 컴퓨터 i번쨰 자리 수와 유저 정답의 i번째 자리수가 같다면 스트라이크 + 1
                if (computerBall.get(i) == num) {
                    ballCount.addStrikeCount();
                    // 다르다면 볼 + 1
                } else {
                    ballCount.addBallCount();
                }
            }
        }

        return ballCount;
    }
}
