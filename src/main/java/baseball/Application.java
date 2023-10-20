package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    static int[] readNumber() {
        String input = Console.readLine();
        try {
            int n = Integer.parseInt(input);
            if (n < 0 || n > 999) {
                throw new IllegalArgumentException();
            }

            int[] result = {n / 100, n / 10 % 10, n % 10};
            if (result[0] == result[1] || result[1] == result[2] || result[2] == result[0]) {
                throw new IllegalArgumentException();
            }

            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        int answer1 = numbers.remove(Randoms.pickNumberInRange(0, 8));
        int answer2 = numbers.remove(Randoms.pickNumberInRange(0, 7));
        int answer3 = numbers.remove(Randoms.pickNumberInRange(0, 6));
        int[] num = readNumber();
    }
}
