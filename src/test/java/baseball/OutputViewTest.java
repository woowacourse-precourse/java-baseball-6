package baseball;

import baseball.baseballV1.model.Ball;
import baseball.baseballV1.model.Game;
import baseball.baseballV1.model.TripleBalls;
import baseball.baseballV1.view.OutputView;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OutputViewTest extends IOTest {
    @Test
    void output_동작_확인() {
        OutputView.displaySentence("check output()");
        Assertions.assertThat(output()).isEqualTo("check output()\n");
    }

    @Test
    void 게임_결과_3스트라이크_확인() {
        Game game = new Game();
        OutputView.displaySentence(game.checkTripleBalls(
                        new TripleBalls(Arrays.asList(new Ball(1, 4),
                                new Ball(2, 5), new Ball(3, 9))),
                        new TripleBalls(Arrays.asList(new Ball(1, 4),
                                new Ball(2, 5), new Ball(3, 9)))
                )
        );

        Assertions.assertThat(output()).isEqualTo("3스트라이크\n");
    }


}
