package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> values;

    public Computer() {
        this.values = new ArrayList<>();
    }

    // 랜덤하게 3자리의 서로 겹치지 않는 숫자(1~9) 고르기
    public void chooseRandomValues() {
        values.clear();
        while (values.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!values.contains(randomNumber)) {
                values.add(randomNumber);
            }
        }
    }

    public ResultDTO compare(List<Integer> playerValues) {
        int[] sb = {0, 0}; // [strike 수, ball 수]
        playerValues.forEach(v -> {
            // 정답에 v가 존재
            if (values.contains(v)) {
                // 같은 자리에 존재
                if (values.get(playerValues.indexOf(v)) == v) {
                    sb[0]++;
                } else {
                    sb[1]++;
                }
            }
        });

        printResult(sb[0], sb[1]);
        return new ResultDTO(sb[0], sb[1]);
    }

    private void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱 ");
        } else {
            if (ball > 0) {
                System.out.printf("%d볼 ", ball);
            }
            if (strike > 0) {
                System.out.printf("%d스트라이크 ", strike);
            }
        }
        System.out.println();
    }
}
