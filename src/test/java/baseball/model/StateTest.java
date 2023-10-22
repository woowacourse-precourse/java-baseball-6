package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.exception.state.NotMatchGameStateException;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class StateTest {

    @Test
    void 재시작_입력이_들어오면_true를_반환한다() {
        // given
        final int restartNumber = 1;

        // when
        final boolean result = State.isMoreGame(restartNumber);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 정해진_상태의_입력이_아닌_경우_예외를_발생시킨다() {
        // given
        final int UndefinedNumber = 3;

        // when & then
        assertThatThrownBy(() -> State.validate(UndefinedNumber))
               .isInstanceOf(NotMatchGameStateException.class);
    }
}
