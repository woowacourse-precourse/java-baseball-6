package baseball;

import java.util.List;

public class Check {
    private final int NUMBER_LENGTH = 3;
    private Result result;
    private int strike;
    private int ball;
    private int nothing;

    Check() {
        result = new Result();
    }

    boolean compareNumber(List<Integer> user, List<Integer> computer) { // 사용자와 컴퓨터의 숫자를 비교하는 함수
        this.strike = 0;
        this.ball = 0;
        this.nothing = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            for (int j = 0; j < NUMBER_LENGTH; j++) {
                if (user.get(i) == computer.get(j)) { // 숫자가 같다면
                    calculatorCount(i, j);
                }
            }
        }
        if (strike == 0 && ball == 0) { // 맞는 숫자가 하나도 없다면
            nothing++;
        }
        return result.print(strike, ball, nothing); // 사용자와 컴퓨터간 결과 출력
    }

    void calculatorCount(int i, int j) { // 같은 자리에 동일한 숫자가 있는지 판단하는 함수
        if (i == j) {
            this.strike++;
        } else {
            this.ball++;
        }
    }
}
