package baseball;

import static baseball.model.message.ErrorMessage.DUPLICATED_NUMBER;
import static baseball.model.message.ErrorMessage.INVALID_INPUT;
import static baseball.model.message.ErrorMessage.INVALID_NUMBER;
import static baseball.model.message.ErrorMessage.INVALID_NUMBERS_LENGTH;
import static baseball.model.message.ErrorMessage.INVALID_RANGE;
import static baseball.model.message.ErrorMessage.INVALID_REPLAY_STATUS;
import static baseball.model.message.ErrorMessage.POSITIVE_NUMBER_NEED;
import static baseball.model.message.UserMessage.ASK_REPLAY_MESSAGE;
import static baseball.model.message.UserMessage.DONE_MESSAGE;
import static baseball.model.message.UserMessage.INPUT_GUIDE_MESSAGE;
import static baseball.model.message.UserMessage.START_MASSAGE;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Nested
    class InputTest {

        @Test
        @DisplayName("빈 문자열 입력은 IllegalArgumentException 발생한다.")
        public void 빈_문자열_입력은_IllegalArgumentException_발생한다() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(" "))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(INVALID_INPUT.getMessage())
            );
        }

        @Test
        @DisplayName("숫자가 아닌 문자 입력은 예외가 발생한다.")
        public void 숫자가_아닌_문자_입력은_예외가_발생한다() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("@@@@"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(INVALID_NUMBER.getMessage())
            );
        }

        @Test
        @DisplayName("음수의 입력은 예외가 발생한다.")
        public void 음수의_입력은_예외가_발생한다() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("-123"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(POSITIVE_NUMBER_NEED.getMessage())
            );
        }

        @Test
        @DisplayName("세자리 숫자가 아닌 입력은 예외가 발생한다.")
        public void 세자리_숫자가_아닌_입력은_예외가_발생한다() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("12345"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(INVALID_NUMBERS_LENGTH.getMessage())
            );
        }

        @Test
        @DisplayName("숫자의 범위가 1에서 9가 아닌 입력은 예외가 발생한다.")
        public void 숫자의_범위가_1에서_9가_아닌_입력은_예외가_발생한다() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("012"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(INVALID_RANGE.getMessage())
            );
        }

        @Test
        @DisplayName("중복 숫자 입력은 예외가 발생한다.")
        public void 중복_숫자_입력은_예외가_발생한다() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("112"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(DUPLICATED_NUMBER.getMessage())
            );
        }

        @Test
        @DisplayName("유효하지 않은 재시작 입력은 IllegalArgumentException 반환한다.")
        public void 유효하지_않은_재시작_입력은_IllegalArgumentException_반환한다() {
            IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
                assertRandomNumberInRangeTest(
                        () -> {
                            run("246", "135", "3");
                        },
                        1, 3, 5
                );
            });

            assertThat(illegalArgumentException).hasMessage(INVALID_REPLAY_STATUS.getMessage());
        }
    }

    @Nested
    class PrintTest {
        @Test
        @DisplayName("게임 시작 시 입력 가이드 메세지를 출력한다.")
        public void 게임_시작_시_입력_가이드_메세지를_출력한다() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "2");
                        assertThat(output()).contains(START_MASSAGE.toString(), INPUT_GUIDE_MESSAGE.toString());
                    },
                    1, 3, 5
            );
        }

        @Test
        @DisplayName("게임 종료 메세지와 재시작 가이드 메세지를 출력한다.")
        public void 게임_종료_메세지와_재시작_가이드_메세지를_출력한다() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "2");
                        assertThat(output()).contains(DONE_MESSAGE.toString(), ASK_REPLAY_MESSAGE.toString());
                    },
                    1, 3, 5
            );
        }
    }
}
