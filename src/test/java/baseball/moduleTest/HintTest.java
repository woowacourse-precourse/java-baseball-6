package baseball.moduleTest;

import baseball.service.Hint;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HintTest {
    @Test
    void 스트라이크_카운트() {
        Hint hint = new Hint();
        ArrayList<Integer> computer = new ArrayList<>() {{
            add(1);
            add(2);
            add(2);
        }};
        ArrayList<Integer> user = new ArrayList<>() {{
            add(1);
            add(2);
            add(2);
        }};
        int count = hint.getStrikeCount(computer, user);
        Assertions.assertEquals(3, count);
    }

    @Test
    void 볼_카운트() {
        Hint hint = new Hint();
        ArrayList<Integer> computer = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};
        ArrayList<Integer> user = new ArrayList<>() {{
            add(3);
            add(2);
            add(1);
        }};
        int count = hint.getBallCount(computer, user);
        Assertions.assertEquals(2, count);
    }
}
