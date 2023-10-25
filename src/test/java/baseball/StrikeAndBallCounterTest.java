package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import baseball.model.StrikeAndBallCounter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class StrikeAndBallCounterTest {

    StrikeAndBallCounter strikeAndBallCounter = new StrikeAndBallCounter();

    @Test
    void 문자열에서_정수형_리스트로() {
        String input = "234";
        List<Integer> output = Arrays.asList(2, 3, 4);

        assertThat(strikeAndBallCounter.setStringToListInteger(input)).isEqualTo(output);
    }

    @Test
    void 스트라이크_볼_개수_세기() {
        List<Integer> computer = Arrays.asList(7, 8, 4);
        List<String> user = Arrays.asList("123", "456", "789", "749");
        List<int[]> strikeAndBallCount = Arrays.asList(
            new int[]{0, 0},
            new int[]{0, 1},
            new int[]{2, 0},
            new int[]{1, 1}
        );

        for (int index = 0; index < user.size(); index++) {
            assertThat(
                strikeAndBallCounter.getStrikeAndBallCount(computer, user.get(index)))
                .isEqualTo(strikeAndBallCount.get(index));
        }
    }
}
