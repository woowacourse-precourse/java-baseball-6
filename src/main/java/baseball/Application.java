package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int RESTART = 1;
    private static final int QUIT = 2;
    private static final int TOTAL_NUMBER_COUNT = 3;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            play();
        } while (isRestart());
    }

    private static boolean isRestart() {
        System.out.println("게임을 새로 시작하려면 " + RESTART + ", 종료하려면 " + QUIT + "를 입력하세요.");
        Integer input = Integer.parseInt(Console.readLine());
        return input.equals(RESTART);
    }

    private static void play() {
        List<Integer> computer = createRandomNumbers();
        List<Integer> user;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            user = parse(Console.readLine());
        } while (isStrikeOut(computer, user));
    }

    private static Boolean isStrikeOut(List<Integer> computer, List<Integer> user) {
        int strike = 0;
        int ball = 0;

        for (Integer c : computer) {
            if (user.contains(c)) {
                if (user.indexOf(c) == computer.indexOf(c)) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }

        printResult(ball, strike);

        if (strike == 3) {
            return false;
        }
        return true;
    }

    private static void printResult(int ball, int strike) {
        List<String> results = new ArrayList<>();
        if (ball != 0) {
            results.add(ball + "볼");
        }

        if (strike != 0) {
            results.add(strike + "스트라이크");
        }

        String resultMessage = results.isEmpty() ? "낫싱" : String.join(" ", results);
        System.out.println(resultMessage);

        if (strike == TOTAL_NUMBER_COUNT) {
            System.out.println(TOTAL_NUMBER_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private static List<Integer> parse(String input) {
        if (input.length() != TOTAL_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }

        List<Integer> parsedInput = new ArrayList<>();

        for (char c : input.toCharArray()) {
            int number = Character.getNumericValue(c);

            if (parsedInput.contains(number)) {
                throw new IllegalArgumentException("중복된 숫자가 있습니다.");
            }

            parsedInput.add(number);
        }

        return parsedInput;
    }

    private static List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
