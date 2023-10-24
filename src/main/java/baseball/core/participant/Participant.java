package baseball.core.participant;

import java.util.List;

public interface Participant {

    default List<Integer> pickNumber() {
        return null;
    }

    default List<Integer> pickNumber(String rawData) {
        return null;
    }

}
