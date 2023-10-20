package game;

import static org.assertj.core.api.Assertions.assertThat;

import client.Ball;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    void 볼2스트라이크0() {
        //given
        Ball computer = new Ball("123");
        Ball player = new Ball("234");
        Referee referee = new Referee(computer, player);

        //when
        BallCounts bc = referee.judge();
        String result = bc.toString();

        //then
        assertThat(result).isEqualTo("2, 0");
    }

    @Test
    void 볼1스트라이크1() {
        //given
        Ball computer = new Ball("123");
        Ball player = new Ball("273");
        Referee referee = new Referee(computer, player);

        //when
        BallCounts bc = referee.judge();
        String result = bc.toString();

        //then
        assertThat(result).isEqualTo("1, 1");
    }

    @Test
    void 볼0스트라이크3() {
        //given
        Ball computer = new Ball("123");
        Ball player = new Ball("123");
        Referee referee = new Referee(computer, player);

        //when
        BallCounts bc = referee.judge();
        String result = bc.toString();

        //then
        assertThat(result).isEqualTo("0, 3");
    }

    @Test
    void 볼0스트라이크2() {
        //given
        Ball computer = new Ball("123");
        Ball player = new Ball("124");
        Referee referee = new Referee(computer, player);

        //when
        BallCounts bc = referee.judge();
        String result = bc.toString();

        //then
        assertThat(result).isEqualTo("0, 2");
    }

    @Test
    void 볼0스트라이크0() {
        //given
        Ball computer = new Ball("123");
        Ball player = new Ball("456");
        Referee referee = new Referee(computer, player);

        //when
        BallCounts bc = referee.judge();
        String result = bc.toString();

        //then
        assertThat(result).isEqualTo("0, 0");
    }
}