package baseball.game;

import java.util.ArrayList;

public interface BaseballGame {

    ArrayList<Integer> comNum();
    ArrayList<Integer> userInput();
    int userAnswer();
    int[] result(ArrayList<Integer> comNum, ArrayList<Integer> userNum);
    void printResult(int[] result);
    void exceptionClose();
}
