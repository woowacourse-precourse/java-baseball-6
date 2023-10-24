package baseball.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.Test;

class ResultFormatStringCreatorTest {

    ResultFormatStringCreator creator = new ResultFormatStringCreatorImpl();

    @Test
    public void 스트라이크3() {
        Map<String, Integer> resultMap = Map.of(
                "스트라이크", 3
        );

        String resultString = creator.toString(resultMap);

        assertEquals(resultString, "3스트라이크");
    }

    @Test
    public void 스트라이크1_볼2() {
        Map<String, Integer> resultMap = Map.of(
                "스트라이크", 1,
                "볼", 2
        );

        String resultString = creator.toString(resultMap);

        assertEquals(resultString, "1스트라이크 2볼");
    }

    @Test
    public void 볼2() {
        Map<String, Integer> resultMap = Map.of(
                "볼", 2
        );

        String resultString = creator.toString(resultMap);

        assertEquals(resultString, "2볼");
    }

    @Test
    public void 낫싱() {
        Map<String, Integer> resultMap = Map.of();

        String resultString = creator.toString(resultMap);

        assertEquals(resultString, "낫싱");
    }

}