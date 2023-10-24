package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.exception.state.NotMatchGameStateException;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class StateTest {

    @CsvSource({"END, false", "PLAY, true"})
    @ParameterizedTest
    void 현재_게임_플레이_중이라면_true를_반환정한다(State state, boolean expected) {
        // when
        final boolean result = State.isMoreGame(state);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 정해진_상태의_입력이_아닌_경우_예외를_발생시킨다() {
        // given
        final String UndefinedNumber = "3";

        // when & then
        assertThatThrownBy(() -> State.createWith(UndefinedNumber))
                .isInstanceOf(NotMatchGameStateException.class);
    }
}
