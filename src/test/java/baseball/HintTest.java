package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class HintTest {

    Hint hint = new Hint();

    @Test
    void 볼과_스트라이크_둘다_존재하지_않을_때의_출력_문자열_테스트() {
        // given & when
        String hintString = hint.toString();

        // then
        Assertions.assertThat(hintString).isEqualTo("낫싱");
    }

    @Test
    void 볼만_존재할_때의_출력_문자열_테스트() {
        // given
        hint.increaseBall();
        hint.increaseBall();

        // when
        String hintString = hint.toString();

        // then
        Assertions.assertThat(hintString).isEqualTo("2볼");
    }

    @Test
    void 스트라이크만_존재할_때의_출력_문자열_테스트() {
        // given
        hint.increaseStrike();
        hint.increaseStrike();

        // when
        String hintString = hint.toString();

        // then
        Assertions.assertThat(hintString).isEqualTo("2스트라이크");
    }

    @Test
    void 볼과_스트라이크_모두_존재할_때의_출력_문자열_테스트() {
        // given
        hint.increaseBall();
        hint.increaseStrike();
        hint.increaseStrike();

        // when
        String hintString = hint.toString();

        // then
        Assertions.assertThat(hintString).isEqualTo("1볼 2스트라이크");
    }

}