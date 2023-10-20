package baseball;

import baseball.utils.RandomUtils;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int[] answer = RandomUtils.getRandomNumbers();
        for (int i =0; i<3; i++) {
            System.out.print(answer[i]);
        }
    }
}
