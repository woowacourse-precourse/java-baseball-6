package baseball;

import camp.nextstep.edu.missionutils.Console;
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

            System.out.println("숫자를 입력해주세요 : ");
            String response = Console.readLine();
            List<Integer> prediction = new ArrayList<>();
            for (int i = 0; i < response.length(); i++) {
                if (!prediction.contains(response.charAt(i) - '0') && 1 <= response.charAt(i) - '0' && response.charAt(i) - '0' <= 10) {
                    prediction.add(response.charAt(i) - '0');
                }
            }

            if (prediction.size() != 3 || response.length() != 3) {
                throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
            }
        }

    }
}
