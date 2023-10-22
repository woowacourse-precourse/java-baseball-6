package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Map;


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
                Map<String, Integer> result = computer.countStrikesAndBalls(guessNumbers);
                printResult(result);
            }

        }

    }

    private static int[] stringToIntArrayThrowException(String input) {
        input = input.replaceAll("\\s", "");

        if (!input.matches("[1-9]+"))
            throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");

        if (input.length() != 3)
            throw new IllegalArgumentException("3자리의 숫자가 아닙니다.");

        int[] result = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .distinct()
                .toArray();

        if (result.length != 3) {
            throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해야됩니다. ");
        }

        return result;
    }

    public static void printResult(Map<String, Integer> result) {

        int strikes = result.get("strikes");
        int balls = result.get("balls");

        if (balls > 0) {
            System.out.print(balls + "볼 ");
        }

        if (strikes > 0) {
            System.out.print(strikes + "스트라이크");
        }

        if (balls == 0 && strikes == 0){
            System.out.print("낫싱");
        }

        System.out.println();
    }
}
