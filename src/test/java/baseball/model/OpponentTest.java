package baseball.model;

import static baseball.fixture.UserNumbersFixture.createUserNumbersByString;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OpponentTest {

    private Opponent opponent;

    @BeforeEach
    void init() {
        opponent = Opponent.createOpponentWithGenerator(new StubNumberGenerator(425));
    }

    @Test
    @DisplayName("같은 수가 같은 자리에 있을 경우 스트라이크 수가 올라간다")
    void when_same_number_locate_same_index_add_strike_count() {
        // given
        UserNumbers userNumbers = createUserNumbersByString("123");

        // when
        GuessResult result = opponent.calculateResult(userNumbers);

        // then
        assertAll(() -> {
            assertEquals(result.getStrikeCount(), 1);
            assertEquals(result.getBallCount(), 0);
        });
    }

    @Test
    @DisplayName("같은 수가 다른 자리에 있으면 볼 수가 올라간다.")
    void when_same_number_locate_other_index_add_ball_count() {
        // given
        UserNumbers userNumbers = createUserNumbersByString("456");

        // when
        GuessResult result = opponent.calculateResult(userNumbers);

        // then
        assertAll(() -> {
            assertEquals(result.getStrikeCount(), 1);
            assertEquals(result.getBallCount(), 1);
        });
    }

    @Test
    @DisplayName("같은 수가 전혀 없으면 낫싱이라는 힌트를 얻는다.")
    void when_() {
        // given
        UserNumbers userNumbers = createUserNumbersByString("789");

        // when
        GuessResult result = opponent.calculateResult(userNumbers);

        // then
        assertTrue(result.isNothing());
    }
}
