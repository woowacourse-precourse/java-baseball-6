package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GamePlayerTest {
    GamePlayer gamePlayer = new GamePlayer();

    @Test
    @DisplayName("숫자를 문자열로 입력받으면 차례대로 숫자로 반환해서 저장해준다.")
    void initThreeNumbers() {
        // given
        String inputtedNumbers = "123";

        // when
        gamePlayer.initThreeNumbers(inputtedNumbers);

        // then
        assertThat(gamePlayer.extractOneNumber(0)).isEqualTo(1);
        assertThat(gamePlayer.extractOneNumber(1)).isEqualTo(2);
        assertThat(gamePlayer.extractOneNumber(2)).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자는 추출받은 만큼만 추출할 수 있다. 그 외로 추출을 시도하면 IndexOutOfBoundsException 예외를 던진다.")
    void 저장한_값보다_더_꺼내려는_경우() {
        // given
        String inputtedNumbers = "123";

        // when
        gamePlayer.initThreeNumbers(inputtedNumbers);

        // then
        assertThatThrownBy(() -> gamePlayer.extractOneNumber(3))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("숫자가 아니면 IllegalArgumentException 예외를 던진다.")
    void 숫자로_입력받지_않은_경우() {
        // given
        String inputtedString = "숫자가 아닌 문자열";

        // when
        assertThatThrownBy(() -> gamePlayer.initThreeNumbers(inputtedString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정답 자릿수만큼의 숫자가 입력되지 않으면 IllegalArgumentException 예외를 던진다.")
    void 정답_자릿수만큼_입력받지_않은_경우() {
        // given
        String inputtedNumbers1 = "1";
        String inputtedNumbers2 = "12";
        String inputtedNumbers3 = "10000000";

        // when
        assertThat(Const.FIXED_ANSWER_CIPHERS).isEqualTo(3);
        // 정답 자릿수는 세 자리다.

        // then
        assertThatThrownBy(() -> gamePlayer.initThreeNumbers(inputtedNumbers1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> gamePlayer.initThreeNumbers(inputtedNumbers2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> gamePlayer.initThreeNumbers(inputtedNumbers3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정해진 숫자 범위 외의 숫자를 입력 받으면 IllegalArgumentException 예외를 던진다.")
    void 정해진_숫자_범위_외의_숫자를_입력받으면 () {
        // given
        String inputtedNumbers1 = "000";
        String inputtedNumbers2 = "001";
        String inputtedNumbers3 = "011";
        String inputtedNumbers4 = "101";

        // when
        assertThat(Const.BASEBALL_START_NUMBER).isEqualTo(1);
        assertThat(Const.BASEBALL_END_NUMBER).isEqualTo(9);
        // 입력 숫자의 범위는 1~9다.

        // then
        assertThatThrownBy(() -> gamePlayer.initThreeNumbers(inputtedNumbers1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> gamePlayer.initThreeNumbers(inputtedNumbers2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> gamePlayer.initThreeNumbers(inputtedNumbers3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> gamePlayer.initThreeNumbers(inputtedNumbers4))
                .isInstanceOf(IllegalArgumentException.class);
    }
}