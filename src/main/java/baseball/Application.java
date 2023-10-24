package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    private static final int NUMBER_LENGTH = 3;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean game = true;

        while (game) {
            List<Integer> computerNumbers = generateRandomNumbers();

            playGame(computerNumbers);

            game = getRestartInput();
        }

        System.out.println("게임을 종료합니다.");
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static void playGame(List<Integer> computerNumbers) {
        boolean gameWin = false;
        while (!gameWin) {
            System.out.println("숫자를 입력해주세요: ");
            String userInput = Console.readLine();


            try {
                List<Integer> userNumbers = parseUserInput(userInput);
                validateUserInput(userNumbers);

                int strikes = countStrikes(computerNumbers, userNumbers);
                int balls = countBalls(computerNumbers, userNumbers);

                printResult(strikes, balls);

                if (strikes == NUMBER_LENGTH) {
                    gameWin = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }

    private static void printResult(int strikes, int balls) {
        String result = "";
        if (balls > 0) {
            result += balls + "볼 ";
        }
        if (strikes > 0) {
            result += strikes + "스트라이크 ";
        }
        if (strikes == 0 && balls == 0) {
            result = "낫싱";
        }
        System.out.println(result);
    }

    private static List<Integer> parseUserInput(String userInput) {
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            userNumbers.add(userInput.charAt(i) - '0');
        }
        return userNumbers;
    }

    private static void validateUserInput(List<Integer> userNumbers) {
        if (userNumbers.size() != NUMBER_LENGTH || hasDuplicateDigits(userNumbers)) {
            throw new IllegalArgumentException("올바른 3자리 서로 다른 숫자를 입력하세요.");
        }
    }

    private static boolean hasDuplicateDigits(List<Integer> numbers) {
        Set<Integer> seen = new HashSet<>();
        for (int num : numbers) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    private static boolean getRestartInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        String input = Console.readLine();
        if ("2".equals(input)) {
            System.out.println("게임 종료");
            return false;
        }
        if (!"1".equals(input)) {
            System.out.println("올바른 숫자를 입력하세요.");
            return getRestartInput();
        }
        return true;
    }

    private static int countStrikes(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikes = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strikes++;
            }
        }
        return strikes;
    }

    private static int countBalls(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int balls = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumbers.contains(userNumbers.get(i)) && !computerNumbers.get(i).equals(userNumbers.get(i))) {
                balls++;
            }
        }
        return balls;
    }
}

