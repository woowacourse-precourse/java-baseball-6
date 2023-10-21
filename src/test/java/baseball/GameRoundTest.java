package baseball;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameRoundTest {

    @Test
    void 잘못된_입력으로_인한_게임_종료() {
        // given
        GameRule rule = new GameRule(3, 1, 9);
        GameRound round = new GameRound(rule);
        String[] inputs = {"abcd", "112", "012", "230"};
        // when
        stdinWillRead(String.join("\n", inputs));
        // then
        for (int i = 0; i < inputs.length; i++) {
            Assertions.assertThrowsExactly(IllegalArgumentException.class,
                    () -> round.play());
        }
    }

    void stdinWillRead(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
