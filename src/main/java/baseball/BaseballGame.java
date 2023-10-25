package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final Integer BALL_INDEX = 0;
    private final Integer STRIKE_INDEX = 1;
    private final Integer NOTHING = 0;
    public static final BaseballGame game = new BaseballGame();

    private List<Integer> compareAnswerWithUserInput(List<Integer> answer, List<Integer> userInput) {
        List<Integer> compared = new ArrayList<>();
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < Validate.BASEBALL_NUM_OF_DIGITS; i++) {
            if (answer.contains(userInput.get(i))) {
                ball++;
                if (answer.get(i).equals(userInput.get(i))) {
                    strike++;
                    ball--;
                }
            }
        }
        compared.add(ball);
        compared.add(strike);
        return compared;
    }

    private Boolean isNothing(List<Integer> compared) {
        return compared.get(BALL_INDEX) == NOTHING && compared.get(STRIKE_INDEX) == NOTHING;
    }

    private Boolean isCorrect(List<Integer> compared) {
        int maxNumOfCorrectness = 3;
        return compared.get(STRIKE_INDEX) == maxNumOfCorrectness;
    }

    private List<Integer> convertUserInputToList(String input) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            list.add(Character.getNumericValue(input.charAt(i)));
        }
        return list;
    }

    private Boolean isContinue(String game) {
        int continueValue = 1;
        return Integer.parseInt(game) == continueValue;
    }

    private void printResult(List<Integer> comparing) {
        String result = "";
        if (comparing.get(BALL_INDEX) > NOTHING) {
            result += String.format(Message.BALL, comparing.get(BALL_INDEX));
        }
        if (comparing.get(STRIKE_INDEX) > NOTHING) {
            result += String.format(Message.STRIKE, comparing.get(STRIKE_INDEX));
        }
        if (result.length() > NOTHING) {
            System.out.println(result);
        }
    }

    public void run() {
        String continueGame;
        System.out.println(Message.START);
        do {
            doGame();
            System.out.println(Message.IS_CONTINUE);
            continueGame = readLine();
            Validate.validateContinueGame(continueGame);
        } while (isContinue(continueGame));
    }

    private void doGame() {
        String number;
        List<Integer> userInput, compared;
        Answer.answer.generateAnswer();
        while (true) {
            System.out.print(Message.INPUT);
            number = readLine();
            Validate.validateNumber(number);
            userInput = convertUserInputToList(number);
            compared = compareAnswerWithUserInput(Answer.answer.getNumber(), userInput);
            printResult(compared);
            if (isCorrect(compared)) {
                System.out.println(Message.CORRECT);
                break;
            }
            if (isNothing(compared)) {
                System.out.println(Message.NOTHING);
            }
        }
    }
}
