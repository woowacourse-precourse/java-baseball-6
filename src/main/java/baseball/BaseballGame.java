package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGame {

    public void play(List<Integer> computer) {
        while (true) {
            int strike = 0;
            int ball = 0;

            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> myNumber = Arrays.stream(Console.readLine().split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (computer.get(i) == myNumber.get(j)) {
                        if (i == j) strike++;
                        else ball++;
                    }
                }
            }

            if (strike == 3) {
                break;
            }

            System.out.println(stringBuilder(ball, strike));
        }
    }

    private StringBuilder stringBuilder(int ball, int strike) {
        StringBuilder sb = new StringBuilder();

        if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        }
        if (ball != 0) {
            sb.append(ball + "볼 ");
        }
        if (strike != 0) {
            sb.append(strike + "스트라이크");
        }

        return sb;
    }
}
