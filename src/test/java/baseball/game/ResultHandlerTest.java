package baseball.game;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import io.GameUserInterface;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultHandlerTest extends NsTest {
    private ResultHandler handler;

    @BeforeEach
    void setup() {
        BaseballGameValueGenerator generator = new BaseballGameValueGenerator();
        GameUserInterface ui = new GameUserInterface(new Converter());
        handler = new ResultHandler(ui, generator);
    }

    @Test
    void 해당되는_결과값을_출력해야함() {
        InningResult oneBallOneStrikeExpectation = InningResult.countMatchesBetween(
                List.of(1, 2, 3),
                List.of(1, 3, 4)
        );
        InningResult threeStrikeExpectation = InningResult.countMatchesBetween(
                List.of(1, 2, 3),
                List.of(1, 2, 3)
        );
        InningResult nothingExpectation = InningResult.countMatchesBetween(
                List.of(1, 2, 3),
                List.of(4, 5, 6)
        );

        handler.handleInningResult(oneBallOneStrikeExpectation);
        handler.handleInningResult(threeStrikeExpectation);
        handler.handleInningResult(nothingExpectation);

        assertThat(output()).contains("1볼 1스트라이크");
        assertThat(output()).contains("3스트라이크");
        assertThat(output()).contains("낫싱");
    }

    @Override
    protected void runMain() {

    }
}