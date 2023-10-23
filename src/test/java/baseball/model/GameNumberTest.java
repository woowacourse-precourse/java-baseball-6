package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameNumberTest {

    @DisplayName("랜덤한 3자리 숫자를 생성한다.")
    @Test
    void createRandomNumber() {
        // given
        int T = 1000;

        while (T --> 0) {
            // when
            Game game = Game.createRandomNumber();
            char[] randNumbers = game.getRandNumber();

            // then
            assertThat(randNumbers).hasSize(3);
            for (char c : randNumbers) {
                assertThat(Character.isDigit(c)).isTrue();
            }
        }
    }
}