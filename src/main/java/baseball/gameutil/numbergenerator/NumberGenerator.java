package baseball.gameutil.numbergenerator;

import java.util.List;

public interface NumberGenerator {

    List<Integer> generate(
        int start,
        int end,
        int count
    );
}
