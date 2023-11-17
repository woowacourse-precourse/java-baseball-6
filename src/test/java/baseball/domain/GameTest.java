package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class GameTest {
    @Test
    @DisplayName("Game 클래스를 생성할 때 computerAnswer가 만들어 진다.")
    void gameGeneratorShouldMakeComputerAnswerAndRegister() {
        // given, when
        Game game = new Game();
        List<Integer> computerAnswer = game.getComputerNumbers();

        // then
        assertThat(computerAnswer)
                .hasSize(3)
                .allMatch(number -> number >= 1 && number <= 9)
                .doesNotHaveDuplicates();
    }
}