package baseball.version2.tools;

import static baseball.version2.constants.Phrases.ANSWER_ERROR_PHRASES;
import static baseball.version2.constants.Value.ANSWER_ARRAY_SIZE;
import static java.lang.Integer.parseInt;

import java.util.ArrayList;

public class Converter {
    public int[] convertStringToArray(String[] answerStringArray, int[] answerArray) {
        int answerOrder = 0;

        try {
            for (String answerValue : answerStringArray) {
                answerArray[answerOrder++] = parseInt(answerValue);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ANSWER_ERROR_PHRASES);
        } catch (ArrayIndexOutOfBoundsException a) {
            throw new IllegalArgumentException(ANSWER_ERROR_PHRASES);
        }
        return answerArray;
    }

    public int convertStringToInt(String playerDecision) {
        int decision;

        try {
            decision = Integer.parseInt(playerDecision);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return decision;
    }

    public int[] convertListToArray(ArrayList<Integer> computerAnswer) {
        int[] answerArray = new int[ANSWER_ARRAY_SIZE];
        int answerOrder = 0;

        for (int answer : computerAnswer) {
            answerArray[answerOrder++] = answer;
        }
        return answerArray;
    }

}
