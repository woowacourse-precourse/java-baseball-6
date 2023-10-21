package baseball.repository;

import java.util.Map;
import java.util.TreeMap;
public class ComputerRepository {
    private int[] answerArray = new int[3];


    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }
}
