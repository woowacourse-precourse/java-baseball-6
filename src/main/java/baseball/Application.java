package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = getRandomNum();

            boolean playGame = true;
            while (playGame) {
                playGame = playRound(computer);
            }

            if (askRestartOrExit()) break;
        }
    }

    private static boolean playRound(List<Integer> computer) {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        List<Integer> userNumbers = getUserNum(input);
        calcResult result = calcResult(userNumbers, computer);
        return printResult(result);
    }

    private static List<Integer> getRandomNum() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private static List<Integer> getUserNum(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        char[] inputChars = input.toCharArray();
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : inputChars) {
            if (!uniqueChars.add(c)) {
                throw new IllegalArgumentException();
            }
        }

        List<Integer> userNumbers = new ArrayList<>();
        for (char c : inputChars) {
            userNumbers.add(Character.getNumericValue(c));
        }
        return userNumbers;
    }

    private static calcResult calcResult(List<Integer> userNumbers, List<Integer> computer) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (Objects.equals(userNumbers.get(i), computer.get(i))) {
                strike++;
            } else if (computer.contains(userNumbers.get(i))) {
                ball++;
            }
        }

        return new calcResult(ball, strike);
    }

    private static boolean printResult(calcResult result) {
        if (result.strike() == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        } else if (result.ball() == 0 && result.strike() == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(result.ball() + "볼 " + result.strike() + "스트라이크");
        }
        return true;
    }

    private static boolean askRestartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choice = Console.readLine();
        if (Objects.equals(choice, "2")) {
            System.out.println("게임을 종료합니다.");
            return true;
        } else {
            System.out.println("게임을 새로 시작합니다.");
            return false;
        }
    }

    private record calcResult(int ball, int strike) {
    }
}
