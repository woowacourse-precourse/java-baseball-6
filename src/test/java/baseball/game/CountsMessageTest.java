package baseball.game;

import static org.assertj.core.api.Assertions.assertThat;
import static baseball.util.CountsMessage.toMessage;

import baseball.constants.MessageConstants;
import org.junit.jupiter.api.Test;

class CountsMessageTest {

    @Test
    void 볼0스트라이크0() {
        //given
        int ball = 0;
        int strike = 0;

        //when
        String result = toMessage(ball, strike);

        //then
        assertThat(result).isEqualTo(MessageConstants.NOTHING_MESSAGE);
    }

    @Test
    void 볼1스트라이크2() {
        //given
        int ball = 1;
        int strike = 2;

        //when
        String result = toMessage(ball, strike);

        //then
        assertThat(result).isEqualTo("1볼 2스트라이크");
    }

    @Test
    void 볼2스트라이크1() {
        //given
        int ball = 2;
        int strike = 1;

        //when
        String result = toMessage(ball, strike);

        //then
        assertThat(result).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void 볼2스트라이크0() {
        //given
        int ball = 2;
        int strike = 0;

        //when
        String result = toMessage(ball, strike);

        //then
        assertThat(result).isEqualTo("2볼");
    }

    @Test
    void 볼0스트라이크3() {
        //given
        int ball = 0;
        int strike = 3;

        //when
        String result = toMessage(ball, strike);

        //then
        assertThat(result).isEqualTo("3스트라이크");
    }
}