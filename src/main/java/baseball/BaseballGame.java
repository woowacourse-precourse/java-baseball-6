package baseball;

import java.util.stream.Stream;

public class BaseballGame {
    private final int computerNum;

    public BaseballGame(int computerNum) {
        this.computerNum = computerNum;
    }

    public BaseballGameResult play(int inputNum) {
        if (computerNum == inputNum) {
            return new BaseballGameResult(3, 0);
        }

        int[] correctNumArr = Stream.of(String.valueOf(computerNum)
                .split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] inputNumArr = Stream.of(String.valueOf(inputNum)
                .split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (inputNumArr[i] == correctNumArr[i]) {
                strike++;
                continue;
            }
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                if (inputNumArr[i] == correctNumArr[j]) {
                    ball++;
                }
            }
        }

        return new BaseballGameResult(strike, ball);
    }
}
