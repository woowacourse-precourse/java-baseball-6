package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        new BaseballGame().start();
    }
}

class BaseballGame {

    private static final int NUM_DIGITS = 3;
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    private static final String FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void start() {
        System.out.println(START_MESSAGE);
        while (true) {
            playRound();
            if (!shouldContinue()) {
                break;
            }
        }
    }

    private void playRound() {
        List<Integer> computer = generateRandomNumbers();
        while (true) {
            String input = getUserInput(INPUT_MESSAGE);
            validateInput(input);

            Result result = check(input, computer);
            printResult(result);

            if (result.getStrikes() == NUM_DIGITS) {
                printWinMessage();
                break;
            }
        }
    }

    private String getUserInput(String prompt) {
        System.out.print(prompt);
        return Console.readLine();
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUM_DIGITS) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNum)) {
                numbers.add(randomNum);
            }
        }
        return numbers;
    }

    private void validateInput(String input) {
        if (input.length() != NUM_DIGITS || !isAllDigits(input) || hasDuplicateCharacters(input)) {
            throwInvalidInputException();
        }
    }

    private boolean isAllDigits(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasDuplicateCharacters(String input) {
        List<Character> characters = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            if (characters.contains(ch)) {
                return true;
            }
            characters.add(ch);
        }
        return false;
    }

    private void throwInvalidInputException() {
        throw new IllegalArgumentException("잘못된 값을 입력했습니다. 애플리케이션을 종료합니다.");
    }

    private Result check(String input, List<Integer> computer) {
        int balls = 0;
        int strikes = 0;
        for (int i = 0; i < NUM_DIGITS; i++) {
            int inputDigit = Character.getNumericValue(input.charAt(i));
            if (computer.contains(inputDigit)) {
                if (computer.get(i).equals(inputDigit)) {
                    strikes++;
                } else {
                    balls++;
                }
            }
        }
        return new Result(balls, strikes);
    }

    private boolean shouldContinue() {
        return "1".equals(getUserInput(RESTART_MESSAGE));
    }

    private void printResult(Result result) {
        System.out.println(result);
    }

    private void printWinMessage() {
        System.out.println(FINISH_MESSAGE);
    }
}

class Result {

    private final int balls;
    private final int strikes;

    public Result(int balls, int strikes) {
        this.balls = balls;
        this.strikes = strikes;
    }

    public int getBalls() {
        return balls;
    }

    public int getStrikes() {
        return strikes;
    }

    @Override
    public String toString() {
        if (balls == 0 && strikes == 0) {
            return "낫싱";
        }
        if (strikes == 0) {
            return String.format("%d볼", balls);
        }
        if (balls == 0) {
            return String.format("%d스트라이크", strikes);
        }
        return String.format("%d볼 %d스트라이크", balls, strikes);
    }
}
