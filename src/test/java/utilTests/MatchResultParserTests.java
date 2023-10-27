package utilTests;

import baseball.container.ApplicationContainer;
import baseball.util.parser.MatchResultParser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MatchResultParserTests {
    private final ApplicationContainer container = new ApplicationContainer();
    private final MatchResultParser matchResultParser = container.getMatchResultParser();

    private final String RESULT_BALL = "볼";
    private final String RESULT_STRIKE = "스트라이크";
    private final String RESULT_NOTHING = "낫싱";

    private int ballCount;
    private int strikeCount;

    @Test
    @DisplayName("볼: 0, 스트라이크: 0 -> 낫싱")
    void test1() {
        // given
        ballCount = 0;
        strikeCount = 0;

        // when
        String result = matchResultParser.parse(ballCount, strikeCount);

        //then
        assertThat(result).isEqualTo(RESULT_NOTHING);

    }

    @Test
    @DisplayName("볼: n, 스트라이크: 0 -> n볼")
    void test2() {
        // given
        ballCount = 3;
        strikeCount = 0;

        // when
        String result = matchResultParser.parse(ballCount, strikeCount);

        //then
        assertThat(result).isEqualTo(ballCount + RESULT_BALL);

    }

    @Test
    @DisplayName("볼: 0, 스트라이크: n -> n스트라이크")
    void test3() {
        // given
        ballCount = 0;
        strikeCount = 3;

        // when
        String result = matchResultParser.parse(ballCount, strikeCount);

        //then
        assertThat(result).isEqualTo(strikeCount + RESULT_STRIKE);

    }

    @Test
    @DisplayName("볼: n, 스트라이크: n -> n볼 n스트라이크")
    void test4() {
        // given
        ballCount = 1;
        strikeCount = 2;

        // when
        String result = matchResultParser.parse(ballCount, strikeCount);

        //then
        assertThat(result).isEqualTo(ballCount + RESULT_BALL + " " + strikeCount + RESULT_STRIKE);

    }
}
