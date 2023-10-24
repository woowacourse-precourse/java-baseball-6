package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            List<Integer> numbers = new ArrayList<>();
            int k = 3;
            while (k > 0) {
                int number = Randoms.pickNumberInRange(1, 9);
                if (!numbers.contains(number)) {
                    numbers.add(number);
                    k--;
                }
            }
        }

    }
}
