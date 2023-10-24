package baseball;

import java.util.List;

class CheckScore {
    private final int numberOfDigits;

    public CheckScore(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
    }

    // strike 개수 계산
    public int countStrike(List<Integer> computer, List<Integer> user) {
        int strike = 0;
        for (int i = 0; i < numberOfDigits; i++) {
            // 인덱스 i의 computer의 숫자와 user의 숫자가 일치하면 strike 개수 증가
            if (computer.get(i).equals(user.get(i))) strike++;
        }
        return strike;
    }

    // ball 개수 계산
    public int countBall(List<Integer> computer, List<Integer> user) {
        int ball = 0;
        for (int i = 0; i < numberOfDigits; i++) {
            // user[i]가 computer에 포함되지만 다른 인덱스에 위치한 경우 ball 개수 증가
            if (computer.contains(user.get(i)) && !computer.get(i).equals(user.get(i))) ball++;
        }
        return ball;
    }
}

