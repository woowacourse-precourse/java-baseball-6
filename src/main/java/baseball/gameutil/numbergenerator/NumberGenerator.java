package baseball.gameutil.numbergenerator;

import java.util.List;

/**
 * 이 인터페이스를 구현하면 숫자를 생성할 수 있다.
 */
public interface NumberGenerator {

    List<Integer> generate(
        int start,
        int end,
        int count
    );
}
