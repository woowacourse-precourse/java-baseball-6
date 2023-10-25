package baseball.model;

import java.util.List;

public interface Playable {
    void updateBaseballNumber(BaseballNumber baseballNumber);
    List<Integer> getBaseballNumber();
}
