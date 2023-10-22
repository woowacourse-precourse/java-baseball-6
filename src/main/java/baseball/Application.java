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
                int[] guessNumbers = stringToIntArrayThrowException(Console.readLine());

            }

        }

    }

    private static int[] stringToIntArrayThrowException(String input) {
        input = input.replaceAll("\\s", "");

        if (!input.matches("[1-9]+"))
            throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");

        return Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
