package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Check {
    private final int NUMBER_LENGTH = 3;
    private Result result;
    Check() {
        result = new Result();
    }

    void compareNumber(List<Integer> user, List<Integer> computer) { // 사용자와 컴퓨터의 숫자를 비교하는 함수
        int strike = 0;
        int ball = 0;
        int nothing = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            for (int j = 0; j < NUMBER_LENGTH; j++) {
                if (user.get(i) == computer.get(j)) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }
        if (strike == 0 && ball == 0) { // 맞는 숫자가 하나도 없다면
            nothing++;
        }
        result.print(strike, ball, nothing);
    }
}
