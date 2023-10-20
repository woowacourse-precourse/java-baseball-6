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
            int index = exist[here - 1];
            if (index == i) {
                strike++;
            } else if (index != 0) {
                ball++;
            }
        }
        return new int[] {strike, ball};
    }

    static boolean readSelection() {
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            List<Integer> numbers = new ArrayList<>();
            while (numbers.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!numbers.contains(randomNumber)) {
                    numbers.add(randomNumber);
                }
            }
            int[] answer = numbers.stream().mapToInt(i -> i).toArray();
            int[] exist = new int[9];
            for (int i = 1; i <= 3; i++) {
                int hereNum = answer[i - 1];
                exist[hereNum - 1] = i;
            }
            // System.out.printf("*** 정답: %s ***\n", Arrays.toString(answer));
            GAME: while (true) {
                int[] userInput = readNumber();
                int[] result = checkAnswer(exist, userInput);
                if (result[1] > 0 && result[0] > 0) {
                    System.out.printf("%d볼 %d스트라이크\n", result[1], result[0]);
                } else if (result[0] > 0) {
                    System.out.printf("%d스트라이크\n", result[0]);
                } else if (result[1] > 0) {
                    System.out.printf("%d볼\n", result[1]);
                } else {
                    System.out.println("낫싱");
                }
                if (result[0] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    boolean again = readSelection();
                    if (again) {
                        break GAME;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
