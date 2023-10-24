package baseball.util;

import java.util.List;

/*
* 재사용 위한 함수
* */
public class CompareNumber {
    private int ball;
    private int strike;

    public CompareNumber() {
        ball = 0;
        strike = 0;
    }

    // 스트라이크, 볼 개수를 계산하는 메서드
    public void countStrikeAndBall(List<Integer> computerNumber, List<Integer> playerNumber) {
        resetCount();

        for (int i = 0; i < 3; i++) {
            int computerDigit = computerNumber.get(i);
            int playerDigit = playerNumber.get(i);

            if (computerDigit == playerDigit) {
                incrementStrike();
            } else if (computerNumber.contains(playerDigit)) {
                incrementBall();
            }
        }
    }

    // 볼, 스트라이크 카운트 리셋
    private void resetCount() {
        ball = 0;
        strike = 0;
    }

    // 스트라이크 개수 증가
    private void incrementStrike() {
        strike++;
    }

    // 볼 개수 증가
    private void incrementBall() {
        ball++;
    }

    // 스트라이크 개수 가져오기
    public int getStrikeCount() {
        return strike;
    }

    // 볼 개수 가져오기
    public int getBallCount() {
        return ball;
    }
}

