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

    static int[] checkAnswer(int[] exist, int[] input) {
        int strike = 0;
        int ball = 0;
        for (int i = 1; i <= 3; i++) {
            int here = input[i - 1];
            int index = exist[here];
            if (index == i) {
                strike++;
            } else if (index != 0) {
                ball++;
            }
        }
        return new int[] {strike, ball};
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        int[] answer = new int[3];
        int[] exist = new int[9];
        for (int i = 1; i <= 3; i++) {
            int hereNum = numbers.remove(Randoms.pickNumberInRange(0, 8 - i));
            answer[i-1] = hereNum;
            exist[hereNum] = i;
        }
        System.out.printf("*** 정답: %s ***\n", Arrays.toString(answer));
        int[] userInput = readNumber();
        int[] result = checkAnswer(exist, userInput);
        if (result[1] > 0) {
            System.out.printf("%d볼 ", result[1]);
        }
        if (result[0] > 0) {
            System.out.printf("%d스트라이크\n", result[0]);
        }
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        }
    }
}
