package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;


public class Application {
    public static void main(String[] args) {
        boolean gameFirstStarted = true;
        while (true) {
            if (gameFirstStarted) {
                System.out.println("숫자 야구 게임을 시작합니다.");
                gameFirstStarted = false;
            }

            Computer computer = new Computer();
            computer.pickNumbers();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                int[] guessNumbers = stringToIntArray(Console.readLine());

            }

        }

    }

    private static int[] stringToIntArray(String input) {
        return Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
