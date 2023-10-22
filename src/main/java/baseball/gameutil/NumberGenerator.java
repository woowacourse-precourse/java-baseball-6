package baseball.gameutil;

import java.util.List;

public interface NumberGenerator {

    public List<Integer> generate(
        Integer start,
        Integer end,
        Integer count
    );
}
