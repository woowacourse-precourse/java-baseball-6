package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class UmpireTest {

    @DisplayName("[1, 2, 3]과 [1, 2, 3] 을 비교하면 3스트라이크를 반환한다.")
    @Test
    void strike3() {
        //given
        //when
        Umpire umpire = new Umpire();

        Computer computer = new Computer(BaseballGameNumbers.of(List.of(1, 2, 3)));

        Player player = new Player();
        player.pickNumber(BaseballGameNumbers.of(List.of(1, 2, 3)));
        //then
        assertThat(umpire.rule(computer, player)).isEqualTo("3스트라이크");
    }

    @DisplayName("[1, 2, 3]과 [1, 2, 4] 을 비교하면 2스트라이크를 반환한다.")
    @Test
    void strike2() {
        //given
        //when
        Umpire umpire = new Umpire();

        Computer computer = new Computer(BaseballGameNumbers.of(List.of(1, 2, 3)));

        Player player = new Player();
        player.pickNumber(BaseballGameNumbers.of(List.of(1, 2, 4)));
        //then
        assertThat(umpire.rule(computer, player)).isEqualTo("2스트라이크");
    }

    @DisplayName("[1, 2, 3]과 [1, 4, 5] 을 비교하면 1스트라이크를 반환한다.")
    @Test
    void strike1() {
        //given
        //when
        Umpire umpire = new Umpire();

        Computer computer = new Computer(BaseballGameNumbers.of(List.of(1, 2, 3)));

        Player player = new Player();
        player.pickNumber(BaseballGameNumbers.of(List.of(1, 4, 5)));
        //then
        assertThat(umpire.rule(computer, player)).isEqualTo("1스트라이크");
    }

    @DisplayName("[1, 2, 3]과 [4, 5, 6] 을 비교하면 낫싱을 반환한다.")
    @Test
    void nothing() {
        //given
        //when
        Umpire umpire = new Umpire();

        Computer computer = new Computer(BaseballGameNumbers.of(List.of(1, 2, 3)));

        Player player = new Player();
        player.pickNumber(BaseballGameNumbers.of(List.of(4, 5, 6)));
        //then
        assertThat(umpire.rule(computer, player)).isEqualTo("낫싱");
    }

    @DisplayName("[1, 2, 3]과 [2, 3, 1] 을 비교하면 볼 3개를 반환한다.")
    @Test
    void ball3() {
        //given
        //when
        Umpire umpire = new Umpire();

        Computer computer = new Computer(BaseballGameNumbers.of(List.of(1, 2, 3)));

        Player player = new Player();
        player.pickNumber(BaseballGameNumbers.of(List.of(2, 3, 1)));
        //then
        assertThat(umpire.rule(computer, player)).isEqualTo("3볼");
    }

    @DisplayName("[1, 2, 3]과 [2, 1, 4] 을 비교하면 볼 2개를 반환한다.")
    @Test
    void ball2() {
        //given
        //when
        Umpire umpire = new Umpire();

        Computer computer = new Computer(BaseballGameNumbers.of(List.of(1, 2, 3)));

        Player player = new Player();
        player.pickNumber(BaseballGameNumbers.of(List.of(2, 1, 4)));
        //then
        assertThat(umpire.rule(computer, player)).isEqualTo("2볼");
    }

    @DisplayName("[1, 2, 3]과 [5, 4, 1] 을 비교하면 볼 1개를 반환한다.")
    @Test
    void ball1() {
        //given
        //when
        Umpire umpire = new Umpire();

        Computer computer = new Computer(BaseballGameNumbers.of(List.of(1, 2, 3)));

        Player player = new Player();
        player.pickNumber(BaseballGameNumbers.of(List.of(5, 4, 1)));
        //then
        assertThat(umpire.rule(computer, player)).isEqualTo("1볼");
    }

    @DisplayName("[1, 2, 3]과 [1, 3, 2] 을 비교하면 볼 2개, 스트라이크 1개를 반환한다.")
    @Test
    void ball2strike1() {
        //given
        //when
        Umpire umpire = new Umpire();

        Computer computer = new Computer(BaseballGameNumbers.of(List.of(1, 2, 3)));

        Player player = new Player();
        player.pickNumber(BaseballGameNumbers.of(List.of(1, 3, 2)));
        //then
        assertThat(umpire.rule(computer, player)).isEqualTo("2볼 1스트라이크");
    }

    @DisplayName("[1, 2, 3]과 [1, 3, 4] 을 비교하면 볼 1개, 스트라이크 1개를 반환한다.")
    @Test
    void ball1strike2() {
        //given
        //when
        Umpire umpire = new Umpire();

        Computer computer = new Computer(BaseballGameNumbers.of(List.of(1, 2, 3)));

        Player player = new Player();
        player.pickNumber(BaseballGameNumbers.of(List.of(1, 3, 4)));
        //then
        assertThat(umpire.rule(computer, player)).isEqualTo("1볼 1스트라이크");
    }
}