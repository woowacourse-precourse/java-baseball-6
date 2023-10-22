package baseball;

import java.util.Map;

public interface OutPut {
    void printScore(Map<String, Integer> result);

    void printFinish();

    boolean askRestart();
}
