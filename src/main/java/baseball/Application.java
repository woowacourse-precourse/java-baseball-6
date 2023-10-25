package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int NUMBERS_COUNT = 3;

    public static void main(String[] args) {
        boolean continuePlaying = true;

        while (continuePlaying) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computerNumbers = createRandomNumbers();

            boolean gameFinished = false;
            while (!gameFinished) {
                List<Integer> userNumbers = getInput();
                gameFinished = playGame(computerNumbers, userNumbers);
            }

            continuePlaying = askNewGame();
        }
    }

    private static List<Integer> createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < NUMBERS_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return numbers;
    }

    private static List<Integer> getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateInput(input);

        List<Integer> userNumbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            userNumbers.add(Character.getNumericValue(c));
        }

        return userNumbers;
    }

    private static void validateInput(String input) {
        if (input.length() != NUMBERS_COUNT || !input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해야 합니다.");
        }
    }

    private static boolean playGame(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < NUMBERS_COUNT; i++) {
            if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                strikes++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                balls++;
            }
        }

        printResult(strikes, balls);

        return strikes == NUMBERS_COUNT;
    }

    private static void printResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
            return;
        }

        if (balls > 0) {
            System.out.print(balls + "볼 ");
        }
        if (strikes > 0) {
            System.out.print(strikes + "스트라이크");
        }

        System.out.println();
        if (strikes == NUMBERS_COUNT) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private static boolean askNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        return "1".equals(input);
    }
}