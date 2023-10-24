package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int NUMBER_LENGTH = 3;
    private static final int MIN_RANDOM = 1;
    private static final int MAX_RANDOM = 9;
    private static final int CONTINUE_GAME = 1;
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean continueGame = true;

        while (continueGame) {
            continueGame = playGame();
        }
    }

    public static boolean playGame() {
        List<Integer> computerNumbers = generateUniqueRandomNumbers();
        boolean gameFinished = false;

        while (!gameFinished) {
            List<Integer> userNumbers = inputAndValidateUserNumbers();
            gameFinished = evaluateAndDisplayGameResult(computerNumbers, userNumbers);
        }

        return askForNewGame();
    }

    public static List<Integer> generateUniqueRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public static List<Integer> inputAndValidateUserNumbers() {
        String input = getUserInput();
        return validateInput(input);
    }

    public static String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static List<Integer> validateInput(String input) {
        if (input.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }

        List<Integer> userNumbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }

            int num = Character.getNumericValue(c);
            if (num < MIN_RANDOM || num > MAX_RANDOM || userNumbers.contains(num)) {
                throw new IllegalArgumentException();
            }

            userNumbers.add(num);
        }
        return userNumbers;
    }

    public static boolean evaluateAndDisplayGameResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int balls = 0;
        int strikes = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strikes++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                balls++;
            }
        }

        return displayGameResult(balls, strikes);
    }

    public static boolean displayGameResult(int balls, int strikes) {
        if (strikes == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else {
            if (balls > 0) {
                System.out.print(balls + "볼 ");
            }
            if (strikes > 0) {
                System.out.println(strikes + "스트라이크");
            } else {
                System.out.println();
            }
        }

        return false;
    }

    public static boolean askForNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = Integer.parseInt(Console.readLine());
        return choice == CONTINUE_GAME;
    }
}