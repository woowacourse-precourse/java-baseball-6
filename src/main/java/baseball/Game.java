package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Game {

    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String USER_INPUT_NUMBER_WORD = "숫자를 입력해주세요 : ";
    private static final String WORD_BALL = "볼";
    private static final String WORD_STRIKE = "스트라이크";
    private static final String WORD_NOTHING = "낫싱";
    private static final String BLANK_WORD = " ";
    private static final String GAME_AGAIN = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String WRONG_ANSWER_INPUT_START_GAME_MESSAGE = "잘못된 값을 입력하셨습니다. 1, 2 만 입력 가능합니다.";
    private static final String WRONG_ANSWER_INPUT_NUMBER_MESSAGE = "잘못된 값을 입력하셨습니다.";
    private static final String WRONG_ANSWER_DUPLICATE_MESSAGE = "서로 다른 세 자리의 숫자만 입력 가능합니다";
    private static final int USER_START_NUMBER = 1;
    private static final int USER_END_NUMBER = 2;
    private final static int COUNT_BALL = 3;
    private static boolean finishFlag = false;

    public static void printStartMessage() {
        System.out.println(GAME_START);
        finishFlag = false;
        while (true) {
            InputNumberMessage();
            int userInput = consoleInputNum();
            int userNumber = validateNumberRange(userInput);
            validateIsDuplicated(userNumber);
            List<Integer> computerNumber = computerNumberRandom();
            System.out.println(computerNumber);
            baseBallGame(userNumber, computerNumber);
            if (finishFlag) {
                break;
            }
        }
    }

    public static void InputNumberMessage() {
        System.out.print(USER_INPUT_NUMBER_WORD);
    }

    public static int consoleInputNum() {
        int userNum = Integer.parseInt(Console.readLine());
        return userNum;
    }

    public static List<Integer> computerNumberRandom() {
        List<Integer> computer = new ArrayList<>();
        int randomNumber = 0;
        while (computer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static int validateNumberRange(int userNumber) {
        if (userNumber >= 123 && userNumber <= 987) {
            return userNumber;
        } else {
            throw new IllegalArgumentException(WRONG_ANSWER_INPUT_NUMBER_MESSAGE);
        }
    }

    public static List<Integer> validateIsDuplicated(int baseballNumber) {
        List<Integer> digits = parseDigits(baseballNumber);

        if (digits.size() != 3 ||
            digits.get(0) == digits.get(1) ||
            digits.get(1) == digits.get(2) ||
            digits.get(0) == digits.get(2) ||
            digits.contains(0)) {
            throw new IllegalArgumentException(WRONG_ANSWER_DUPLICATE_MESSAGE);
        }
        return digits;
    }

    private static List<Integer> parseDigits(int baseballNumber) {
        List<Integer> digits = new ArrayList<>();
        while (baseballNumber != 0) {
            digits.add(baseballNumber % 10);
            baseballNumber /= 10;
        }
        Collections.reverse(digits);
        return digits;
    }

    public static void baseBallGame(int userNumber, List<Integer> computerNumber) {
        int ballCount = ball(userNumber, computerNumber);
        int strikeCount = strike(userNumber, computerNumber);

        if (ballCount > 0 && strikeCount > 0) {
            System.out.println(ballCount + WORD_BALL + BLANK_WORD + strikeCount + WORD_STRIKE);
            baseBallGame(reInputUserNum(), computerNumber);
        } else if (ballCount > 0 && strikeCount == 0) {
            System.out.println(ballCount + WORD_BALL);
            baseBallGame(reInputUserNum(), computerNumber);
        } else if (ballCount == 0 && strikeCount > 0 && strikeCount != 3) {
            System.out.println(strikeCount + WORD_STRIKE);
            baseBallGame(reInputUserNum(), computerNumber);
        } else if (ballCount == 0 && strikeCount > 0 && strikeCount == 3) {
            System.out.println(strikeCount + WORD_STRIKE);
            System.out.println(GAME_END_MESSAGE);
            System.out.println(GAME_AGAIN);
            startEndGame();
        } else if (ballCount == 0 && strikeCount == 0) {
            System.out.println(WORD_NOTHING);
            baseBallGame(reInputUserNum(), computerNumber);
        }
    }

    public static int reInputUserNum() {
        InputNumberMessage();
        int userInput = consoleInputNum();
        int userNumber = validateNumberRange(userInput);
        validateIsDuplicated(userNumber);
        return userNumber;
    }

    public static int ball(int usernumber, List<Integer> computernumber) {
        List<Integer> userNum = parseDigits(usernumber);
        List<Integer> computerNum = computernumber;
        int ball = 0;

        for (int i = 0; i < COUNT_BALL; i++) {
            for (int j = 0; j < COUNT_BALL; j++) {
                if (i != j && userNum.get(i).equals(computerNum.get(j))) {
                    ball++;
                }
            }
        }
        return ball;
    }

    public static int strike(int usernumber, List<Integer> computernumber) {
        List<Integer> userNum = parseDigits(usernumber);
        List<Integer> computerNum = computernumber;

        int strike = 0;

        for (int i = 0; i < COUNT_BALL; i++) {
            if (userNum.get(i).equals(computerNum.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public static void startEndGame() {
        int userChoice = consoleInputNum();
        if (userChoice == USER_START_NUMBER) {
            finishFlag = false;
        } else if (userChoice == USER_END_NUMBER) {
            finishFlag = true;
        } else if (userChoice != USER_END_NUMBER && userChoice != USER_START_NUMBER) {
            throw new IllegalArgumentException(WRONG_ANSWER_INPUT_START_GAME_MESSAGE);
        }
    }
}
