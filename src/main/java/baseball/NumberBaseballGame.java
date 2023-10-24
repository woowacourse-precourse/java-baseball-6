package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberBaseballGame {
    private static final String GAME_PLAY_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String USER_GUESS_INPUT_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String GAME_FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String GAME_CONTINUE_COMMAND = "1";
    private static final String GAME_QUIT_COMMAND = "2";

    private static final int BALL_COUNT = 3;

    private Balls computerBalls;

    public void play() {
        System.out.println(GAME_PLAY_START_MESSAGE);
        do {
            mainGameLogic();
        } while (checkUserContinue());
    }

    private void mainGameLogic() {
        generateComputerBalls();
        while (true) {
            String userGuess = getInputWithPrompt(USER_GUESS_INPUT_MESSAGE);
            validateUserGuessInput(userGuess);
            Balls userBalls = userGuessToUserBalls(userGuess);
            Result result = Judge.judge(computerBalls, userBalls, BALL_COUNT);
            printResult(result);
            if (isGameEnded(result)) {
                break;
            }
        }
    }

    private boolean checkUserContinue() {
        String userRetryInput = getInputWithPrompt(GAME_FINISH_MESSAGE);
        validateUserRetryInput(userRetryInput);
        return userRetryInput.equals(GAME_CONTINUE_COMMAND);
    }

    private boolean isGameEnded(Result result) {
        return result.strikeCount() == BALL_COUNT;
    }

    private static void validateUserRetryInput(String userRetryInput) {
        if (!(userRetryInput.equals(GAME_CONTINUE_COMMAND) || userRetryInput.equals(GAME_QUIT_COMMAND))) {
            throw new IllegalArgumentException();
        }
    }

    private String getInputWithPrompt(String prompt) {
        System.out.print(prompt);
        return Console.readLine();
    }

    private Balls userGuessToUserBalls(String userGuess) {
        List<Integer> integerList = stringToList(userGuess);
        return new Balls(integerList);
    }

    private void printResult(Result result) {
        String prompt = "";
        int ballCount = result.ballCount();
        int strikeCount = result.strikeCount();
        if (ballCount > 0) {
            prompt += ballCount + BALL_MESSAGE;
        }
        if (strikeCount > 0) {
            if (!prompt.isEmpty()) {
                prompt += " ";
            }
            prompt += strikeCount + STRIKE_MESSAGE;
        }
        if (prompt.isEmpty()) {
            prompt = NOTHING_MESSAGE;
        }
        System.out.println(prompt);
    }


    private void validateUserGuessInput(String userGuessInput) {
        if (!userGuessInput.matches("\\d{3}")) {
            throw new IllegalArgumentException();
        }
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : userGuessInput.toCharArray()) {
            uniqueChars.add(c);
        }
        if (uniqueChars.size() != userGuessInput.length()) {
            throw new IllegalArgumentException();
        }
    }

    private void generateComputerBalls() {
        List<Integer> computerSecretNumber = new ArrayList<>();
        while (computerSecretNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerSecretNumber.contains(randomNumber)) {
                computerSecretNumber.add(randomNumber);
            }
        }
        computerBalls = new Balls(computerSecretNumber);
    }

    public List<Integer> stringToList(String str) {
        List<Integer> result = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                result.add(Character.getNumericValue(c));
            }
        }
        return result;
    }
}
