package baseball.domain.player;

import baseball.domain.number.Numbers;
import java.util.List;

public interface Player {

    Numbers getNumbers();
    List<Integer> getNumberList();
    void changeNumbers(Numbers numbers);
    void reset();

}
