package baseball.game;

import java.util.ArrayList;

public interface BaseballGame {
    void gameInit(boolean round);
    ArrayList<Integer> comNum();
    ArrayList<Integer> userInput();
    int userAnswer();
    int[] result();
    void printResult(int[] result);
    void exceptionClose();
    int getStrike();
}
