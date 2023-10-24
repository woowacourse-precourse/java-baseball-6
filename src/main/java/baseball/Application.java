package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

enum ScoreType {
    strike, ball
}

public class Application {
    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computerNumber = getRandomNumber();

            boolean playGame = true;
            while (playGame) {
                playGame = playRound(computerNumber);
            }

            if (askRestartOrExit()) {
                break;
            }
        }
    }

    private static boolean playRound(List<Integer> computerNumber) {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();

        List<Integer> userNumbers = getUserNumbers(input);
        ScoreType result = calculateScore(userNumbers, computerNumber);
        return printResult(result);
    }

    private static List<Integer> getRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers add(randomNumber);
            }
        }
        return numbers;
    }

    private static List<Integer> getUserNumbers(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력은 반드시 세 자리여야 합니다.");
        }

        char[] inputChars = input.toCharArray();
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : inputChars) {
            if (!uniqueChars.add(c)) {
                throw new IllegalArgumentException("입력은 각 숫자가 고유해야 합니다.");
            }
        }

        List<Integer> userNumbers = new ArrayList<>();
        for (char c : inputChars) {
            userNumbers add(Character.getNumericValue(c));
        }
        return userNumbers;
    }

    private static ScoreType calculateScore(List<Integer> userNumbers, List<Integer> computerNumber) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (userNumbers.get(i).equals(computerNumber.get(i)) {
                strike++;
            } else if (computerNumber.contains(userNumbers.get(i))) {
                ball++;
            }
        }

        if (strike == 3) {
            return ScoreType.strike;
        } else if (ball == 0 && strike == 0) {
            return null;
        } else {
            return ScoreType.ball;
        }
    }

    private static boolean printResult(ScoreType result) {
        if (result == ScoreType.strike) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        } else if (result == null) {
            System.out.println("낫싱");
        } else {
            int ballCount = 0;
            int strikeCount = 0;
            if (result == ScoreType.ball) {
                ballCount++;
            } else {
                strikeCount++;
            }
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
        return true;
    }

    private static boolean askRestartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choice = Console.readLine();
        if ("2".equals(choice)) {
            System.out.println("게임을 종료합니다.");
            return true;
        } else {
            System.out.println("게임을 새로 시작합니다.");
            return false;
        }
    }
}
