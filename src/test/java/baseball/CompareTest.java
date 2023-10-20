package baseball;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompareTest {
    @Test
    void 모두_맞혔을_경우_3_스트라이크() {
        List<Integer> mockData = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
        }};
        Answer answer = new Answer(mockData);

        List<Integer> mockInput = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
        }};

        GameScore gameScore = answer.calcScore(mockInput);
        List<Integer> result = gameScore.getResult();
        Assertions.assertThat(result.get(0)).isEqualTo(3);
        Assertions.assertThat(result.get(1)).isEqualTo(0);
    }

    @Test
    void 모두_볼인_경우() {
        List<Integer> mockData = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
        }};
        Answer answer = new Answer(mockData);

        List<Integer> mockInput = new ArrayList<>(){{
            add(3);
            add(1);
            add(2);
        }};

        GameScore gameScore = answer.calcScore(mockInput);
        List<Integer> result = gameScore.getResult();
        Assertions.assertThat(result.get(0)).isEqualTo(0);
        Assertions.assertThat(result.get(1)).isEqualTo(3);
    }

    @Test
    void 스트라이크_1개인_경우() {
        List<Integer> mockData = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
        }};
        Answer answer = new Answer(mockData);

        List<Integer> mockInput = new ArrayList<>(){{
            add(1);
            add(7);
            add(9);
        }};

        GameScore gameScore = answer.calcScore(mockInput);
        List<Integer> result = gameScore.getResult();
        Assertions.assertThat(result.get(0)).isEqualTo(1);
        Assertions.assertThat(result.get(1)).isEqualTo(0);
    }
}
