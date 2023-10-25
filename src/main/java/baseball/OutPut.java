package baseball;

import java.util.Map;

public interface OutPut {
    void printStart();

    void printInputRequest();

    void printScore(Map<String, Integer> result);

    void printFinish();

    void askRestart();
}
