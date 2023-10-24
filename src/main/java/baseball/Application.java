package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final int NUMBER_LENGTH = 3;
    private static final int MIN_RANDOM_DIGIT = 1;
    private static final int MAX_RANDOM_DIGIT = 9;
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_PROMPT = "숫자를 입력해주세요 : ";
    private static final String GAME_WIN_MESSAGE = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String RESTART_GAME_CODE = "1";
    private static final String EXIT_GAME_CODE = "2";

    public static void main(String[] args) {
        System.out.println(GAME_START_MESSAGE);
        playBaseballGame();
    }

    private static void playBaseballGame() {
        String gameCode;
        do {
            List<Integer> randomNumber = createRandomNumber();
            gameCode = playSingleRound(randomNumber);
        } while (gameCode.equals(RESTART_GAME_CODE));
    }

    private static String playSingleRound(List<Integer> randomNumber) {
        int[] ballAndStrike;

        do {
            List<Integer> userNumber = getUserNumber();
            ballAndStrike = calculateBallAndStrike(userNumber, randomNumber);

            printResult(ballAndStrike[0], ballAndStrike[1]);
        } while (ballAndStrike[1] != NUMBER_LENGTH);

        return getValidGameCode();
    }

    private static String getValidGameCode() {
        String gameCode;
        do {
            System.out.println(GAME_RESTART_MESSAGE);
            gameCode = Console.readLine();
        } while (!gameCode.equals(RESTART_GAME_CODE) && !gameCode.equals(EXIT_GAME_CODE));
        return gameCode;
    }

    private static int[] calculateBallAndStrike(List<Integer> userNumber, List<Integer> randomNumber) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            Integer randomDigit = randomNumber.get(i);
            Integer userDigit = userNumber.get(i);

            if (randomDigit.equals(userDigit)) {
                strike += 1;
            } else if (randomNumber.contains(userDigit)) {
                ball += 1;
            }
        }

        return new int[]{ball, strike};
    }

    private static void printResult(int ball, int strike) {
        String resultMessage = "";
        if (strike == NUMBER_LENGTH) {
            resultMessage = strike + STRIKE + "\n" + NUMBER_LENGTH + GAME_WIN_MESSAGE;
        } else if (ball > 0 && strike > 0) {
            resultMessage = ball + BALL + " " + strike + STRIKE;
        } else if (ball > 0) {
            resultMessage = ball + BALL;
        } else if (strike > 0) {
            resultMessage = strike + STRIKE;
        } else if (ball == 0 && strike == 0) {
            resultMessage = NOTHING;
        }
        System.out.println(resultMessage);
    }

    private static List<Integer> createRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_DIGIT, MAX_RANDOM_DIGIT);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static List<Integer> getUserNumber() {
        List<Integer> userNumber = new ArrayList<>();
        String userInput;
        String[] tempNumber;
        boolean isValid;

        System.out.print(INPUT_PROMPT);
        userInput = Console.readLine();
        isValid = isValidNumber(userInput);

        if (isValid) {
            tempNumber = userInput.split("");
            for (String s : tempNumber) {
                userNumber.add(Integer.parseInt(s));
            }
        } else if (!isValid) {
            throw new IllegalArgumentException();
        }

        return userNumber;
    }

    private static boolean isValidNumber(String input) {
        if (input.length() != NUMBER_LENGTH) {
            return false;
        }

        for (char ch : input.toCharArray()) {
            if (ch < '1' || ch > '9') {
                return false;
            }
        }

        if (input.charAt(0) == input.charAt(1)
                || input.charAt(0) == input.charAt(2)
                || input.charAt(1) == input.charAt(2)) {
            return false;
        }

        return true;
    }
}