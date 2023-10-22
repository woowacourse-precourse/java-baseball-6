package baseball.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.Application;
import baseball.exception.view.InputBlankException;
import baseball.exception.view.InputCanNotChangeToIntException;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class ConsoleInputViewTest extends NsTest {

    @Test
    void 입력_값이_비어있으면_예외를_발생시킨다() {
        // given
        String blank = " ";

        // when & then
        assertThatThrownBy(() -> run(blank))
                .isInstanceOf(InputBlankException.class);
    }

    @Test
    void 입력_문자열이_숫자로_변환이_불가능하면_예외를_발생시킨다() {
        // given
        String str = "test";

        // when & then
        assertThatThrownBy(() -> run(str))
               .isInstanceOf(InputCanNotChangeToIntException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
