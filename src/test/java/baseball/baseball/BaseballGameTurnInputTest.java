package baseball.baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseballGameTurnInputTest {

    @Test
    public void 세자리가_아닌_숫자가_들어오면_예외를_발생시킨다() throws Exception {
        // given
        // when
        //then
        assertThatThrownBy(() -> {
            new BaseballGameTurnInput("1234");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 숫자가_아니면_예외를_발생시킨다() throws Exception {
        // given
        // when
        //then
        assertThatThrownBy(() -> {
            new BaseballGameTurnInput("1aa");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 중복된_숫자면_예외를_발생시킨다() throws Exception {
        // given
        // when
        //then
        assertThatThrownBy(() -> {
            new BaseballGameTurnInput("112");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}