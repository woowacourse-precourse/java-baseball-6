package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public interface NumberGenerator {

    List<Integer> pickedNumbers = new ArrayList<>();

    int generate();

    default List<Integer> getPickedNumbers() {
        return pickedNumbers;
    }
}
