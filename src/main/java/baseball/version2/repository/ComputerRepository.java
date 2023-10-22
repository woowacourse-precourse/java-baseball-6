package baseball.version2.repository;

import static baseball.version2.Constants.Value.*;

public class ComputerRepository {

    private int[] answerArray = new int[ANSWER_ARRAY_SIZE];


    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }
}
