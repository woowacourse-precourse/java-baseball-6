package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            play();
        } while (isRestart());
    }

    private static boolean isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Integer input = Integer.parseInt(Console.readLine());
        if (input == 1) {
            return true;
        }
        return false;
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
            results.add(String.format("%d볼", ball));
        }
        if (strike != 0) {
            results.add(String.format("%d스트라이크", strike));
        }

        if (results.size() != 0) {
            System.out.println(String.join(" ", results));
        } else {
            System.out.println("낫싱");
        }

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private static List<Integer> parse(String input) {
        List<Integer> parsedInput = new ArrayList<>();

        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        String[] listedInput = input.split("");

        for (String strNumber : listedInput) {
            int number = Integer.parseInt(strNumber);

            if (!parsedInput.contains(number)) {
                parsedInput.add(number);
            } else {
                throw new IllegalArgumentException();
            }
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
