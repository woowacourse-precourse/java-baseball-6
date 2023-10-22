package baseball.version2.view;

import static baseball.version2.Constants.Phrases.*;

import baseball.version2.DataValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final DataValidator dataValidator;


    public InputView() {
        this.dataValidator = new DataValidator();
    }

    public int[] getPlayerAnswer(int arraySize) {
        System.out.print(INSERT_ANSWER_PHRASES);
        String playerAnswer = Console.readLine();
        String[] answerStringArray = playerAnswer.split("");
        int[] answerArray = new int[arraySize];
        answerArray=dataValidator.validateIsNumberAndSize(answerStringArray, answerArray);
        dataValidator.validatePlayerAnswer(answerArray);
        return answerArray;
    }


    public int getPlayerDecision() {
        System.out.println(SELECT_CONTINUE_PHRASES);
        String playerDecision = Console.readLine();
        int decision = 0;
        try {
            decision = Integer.parseInt(playerDecision);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        dataValidator.validateDecision(decision);

        return decision;
    }


}
