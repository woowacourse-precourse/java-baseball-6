package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BaseballGame {
    private final String BALL_KEY = "ball";
    private final String STRIKE_KEY = "strike";
    private final Integer NOTHING = 0;
    public static final BaseballGame game = new BaseballGame();

    private Map<String, Integer> compareAnswerWithUserInput(List<Integer> answer, List<Integer> userInput) {
        Map<String, Integer> comparedResult = new HashMap<>();
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < Validate.BASEBALL_NUM_OF_DIGITS; i++) {
            if (answer.get(i).equals(userInput.get(i))) {
                strike++;
            } else if (answer.contains(userInput.get(i))) {
                ball++;
            }
        }
        comparedResult.put(BALL_KEY, ball);
        comparedResult.put(STRIKE_KEY, strike);
        return comparedResult;
    }

    private Boolean isNothing(Map<String, Integer> comparedResult) {
        return Objects.equals(comparedResult.get(BALL_KEY), NOTHING)
                && Objects.equals(comparedResult.get(STRIKE_KEY), NOTHING);
    }

    private Boolean isCorrect(Map<String, Integer> comparedResult) {
        int maxNumOfCorrectness = 3;
        return comparedResult.get(STRIKE_KEY) == maxNumOfCorrectness;
    }

    private List<Integer> convertUserInputToList(String input) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            list.add(Character.getNumericValue(input.charAt(i)));
        }
        return list;
    }

    private Boolean isRestart(String game) {
        int continueValue = 1;
        return Integer.parseInt(game) == continueValue;
    }

    private void printResult(Map<String, Integer> comparedResult) {
        String result = "";
        if (comparedResult.get(BALL_KEY) > NOTHING) {
            result += String.format(Message.BALL, comparedResult.get(BALL_KEY));
        }
        if (comparedResult.get(STRIKE_KEY) > NOTHING) {
            result += String.format(Message.STRIKE, comparedResult.get(STRIKE_KEY));
        }
        if (result.length() > NOTHING) {
            System.out.println(result);
        }
    }

    public void run() {
        String restartGame;
        System.out.println(Message.START);
        do {
            doGame();
            System.out.println(Message.RESTART);
            restartGame = getRestartGame();
        } while (isRestart(restartGame));
    }

    private List<Integer> getUserInput() {
        String number = readLine();
        Validate.validateNumber(number);
        return convertUserInputToList(number);
    }

    private String getRestartGame() {
        String restartGame = readLine();
        Validate.validateContinueGame(restartGame);
        return restartGame;
    }

    private void doGame() {
        List<Integer> userInput;
        Map<String, Integer> comparedResult;
        Answer.answer.generateAnswer();
        while (true) {
            System.out.print(Message.INPUT);
            userInput = getUserInput();
            comparedResult = compareAnswerWithUserInput(Answer.answer.getNumber(), userInput);
            printResult(comparedResult);
            if (isCorrect(comparedResult)) {
                System.out.println(Message.CORRECT);
                break;
            }
            if (isNothing(comparedResult)) {
                System.out.println(Message.NOTHING);
            }
        }
    }
}
