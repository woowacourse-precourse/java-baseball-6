package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class HintTest {

    @Test
    void 볼과_스트라이크_둘다_존재하지_않을_때의_출력_문자열_테스트() {
        // given
        int strike = 0, ball = 0;
        Hint hint = new Hint(strike, ball);

        // given & when
        String hintString = hint.toString();

        // then
        Assertions.assertThat(hintString).isEqualTo("낫싱");
    }

    @Test
    void 볼만_존재할_때의_출력_문자열_테스트() {
        // given
        int strike = 0, ball = 2;
        Hint hint = new Hint(strike, ball);

        // when
        String hintString = hint.toString();

        // then
        Assertions.assertThat(hintString).isEqualTo(ball + "볼");
    }

    @Test
    void 스트라이크만_존재할_때의_출력_문자열_테스트() {
        // given
        int strike = 2, ball = 0;
        Hint hint = new Hint(strike, ball);

        // when
        String hintString = hint.toString();

        // then
        Assertions.assertThat(hintString).isEqualTo(strike + "스트라이크");
    }

    @Test
    void 볼과_스트라이크_모두_존재할_때의_출력_문자열_테스트() {
        // given
        int strike = 2, ball = 1;
        Hint hint = new Hint(strike, ball);

        // when
        String hintString = hint.toString();

        // then
        Assertions.assertThat(hintString).isEqualTo(ball + "볼 " + strike + "스트라이크");
    }

}