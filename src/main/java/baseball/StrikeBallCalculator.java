package baseball;

import java.util.List;

public class StrikeBallCalculator {
    /*
     * 스트라이크, 볼 여부를 판단
     */
    public static int[] calculate(int[] guess, List<Integer> answer) {
        int[] result = new int[2]; // ball, strike 순서

        for (int i = 0; i < Constants.NUMBER_COUNT; i++) {
            if (guess[i] == answer.get(i)) {
                result[1]++; // 스트라이크 증가
            } else {
                for (int j = 0; j < Constants.NUMBER_COUNT; j++) {
                    if (i != j && guess[i] == answer.get(j)) {
                        result[0]++; // 볼 증가
                    }
                }
            }
        }

        return result;
    }
}

