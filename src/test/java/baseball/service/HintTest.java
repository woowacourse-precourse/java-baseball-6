package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class HintTest {

    @Test
    void 낫싱() {
        String hint = Hint.makeHint(0, 0);
        assertThat(hint).isEqualTo("낫싱");
    }

    @Test
    void 볼_0개_스트라이크_1개() {
        String hint = Hint.makeHint(0, 1);
        assertThat(hint).isEqualTo("1스트라이크");
    }

    @Test
    void 볼_0개_스트라이크_2개() {
        String hint = Hint.makeHint(0, 2);
        assertThat(hint).isEqualTo("2스트라이크");
    }

    @Test
    void 볼_0개_스트라이크_3개() {
        String hint = Hint.makeHint(0, 3);
        assertThat(hint).isEqualTo("3스트라이크");
    }

    @Test
    void 볼_1개_스트라이크_0개() {
        String hint = Hint.makeHint(1, 0);
        assertThat(hint).isEqualTo("1볼");
    }

    @Test
    void 볼_1개_스트라이크_1개() {
        String hint = Hint.makeHint(1, 1);
        assertThat(hint).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 볼_1개_스트라이크_2개() {
        //나올 수 없는 경우
    }

    @Test
    void 볼_2개_스트라이크_0개() {
        String hint = Hint.makeHint(2, 0);
        assertThat(hint).isEqualTo("2볼");
    }

    @Test
    void 볼_2개_스트라이크_1개() {
        String hint = Hint.makeHint(2, 1);
        assertThat(hint).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void 볼_3개_스트라이크_0개() {
        String hint = Hint.makeHint(3, 0);
        assertThat(hint).isEqualTo("3볼");
    }
}