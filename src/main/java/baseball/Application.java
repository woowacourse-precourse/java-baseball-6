package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        boolean continueGame = true;
        while (continueGame) {
            List<Integer> computerNumber = generateComputerNumber();
            continueGame = playGame(computerNumber);
        }
    }

    private static List<Integer> generateComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    private static boolean playGame(List<Integer> computerNumber) {
        int strikeCount = 0;
        while (strikeCount != 3) {
            System.out.println("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            List<Integer> userNumber = parseInput(input);
            strikeCount = calculateStrike(computerNumber, userNumber);
            int ballCount = calculateBall(computerNumber, userNumber);
            printResult(strikeCount, ballCount);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return askRestartGame();
    }

    private static List<Integer> parseInput(String input) {
        if (input.length() != 3 || !input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("Invalid input. Please enter a 3-digit number.");
        }
        return input.chars().mapToObj(c -> c - '0').collect(Collectors.toList());
    }

    private static int calculateStrike(List<Integer> computerNumber, List<Integer> userNumber) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private static int calculateBall(List<Integer> computerNumber, List<Integer> userNumber) {
        int ballCount = 0;
        for (int number : userNumber) {
            if (computerNumber.contains(number) && !computerNumber.get(userNumber.indexOf(number)).equals(number)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private static void printResult(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        } else if (strikeCount > 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (strikeCount == 0) {
            System.out.println(ballCount + "볼");
        } else {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    private static boolean askRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if ("1".equals(input)) {
            return true;
        } else if ("2".equals(input)) {
            return false;
        } else {
            throw new IllegalArgumentException("Invalid input. Please enter 1 or 2.");
        }
    }
}
