package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class GameNumberTest {

    @DisplayName("랜덤한 각 자리수가 다른 3자리 숫자를 생성한다.")
    @Test
    void createRandomNumber() {
        // given
        int T = 1000;

        while (T-- > 0) {
            // when
            Game game = Game.createRandomNumber();
            Set<Character> randNumberSet = new HashSet<>();
            for (char randNumber : game.getRandNumber()) {
                randNumberSet.add(randNumber);
            }

            // then
            assertThat(randNumberSet).hasSize(3);
            for (char c : randNumberSet) {
                assertThat(Character.isDigit(c)).isTrue();
            }
        }
    }


    @DisplayName("입력된 수의 스트라이크, 볼의 개수를 카운트한다.")
    @Test
    void countStrikeAndBall() {
        // given
        Game game = Game.createRandomNumber();

        // when
        int[] array = game.checkScoreResult(String.valueOf(game.getRandNumber()));

        // then
        assertThat(array).contains(0, 3);
    }

    @DisplayName("입력된 수의 스트라이크, 볼의 개수를 카운트한다.")
    @Test
    void countStrikeAndBall2() {
        // given
        Game game = Game.createRandomNumberForInput(new char[]{'1', '2', '3'});
        // when
        int[] array = game.checkScoreResult(String.valueOf("321"));

        // then
        assertThat(array).contains(2, 1);
    }

    @DisplayName("입력된 수의 스트라이크, 볼의 개수를 카운트한다.")
    @Test
    void countStrikeAndBall3() {
        // given
        Game game = Game.createRandomNumberForInput(new char[]{'1', '2', '3'});
        // when
        int[] array = game.checkScoreResult(String.valueOf("435"));

        // then
        assertThat(array).contains(1, 0);
    }
}