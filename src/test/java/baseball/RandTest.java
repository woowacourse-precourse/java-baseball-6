package baseball;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandTest {

    @Test
    void 난수_생성_여부_확인() {
        NumberGenerator generator = new NumberGenerator();
        Answer answer = generator.createAnswer();

        List<Integer> mockInput = new ArrayList<>(){{
            add(3);
            add(1);
            add(2);
        }};

        GameScore gameScore = answer.calcScore(mockInput);
        List<Integer> result = gameScore.getResult();

        Assertions.assertThat(result.get(0)).isNotNull();
        Assertions.assertThat(result.get(1)).isNotNull();
    }
}
