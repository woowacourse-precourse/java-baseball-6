package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 테스트는 서로 독립적으로 이루어져야 한다.
 * <p>
 * 즉, makeComputerRandom.createRandom() 메서드 & makeUserAnswer.input() 사용하지 않고 오직 야구 게임의 로직만을 테스트하는 것이 목표이다.
 */

class PlayTest {
    private final Play play;

    public PlayTest() {
        play = new Play();
    }

    @DisplayName("낫싱")
    @Test
    void nothing() {
        //given
        Computer computer = Computer.createComputer(List.of(1, 2, 3));
        User user = new User(List.of(5, 6, 7));

        //when
        play.playBaseBallGame(computer, user);

        //then
        Assertions.assertThat(user.getStrike()).isEqualTo(0);
        Assertions.assertThat(user.getBall()).isEqualTo(0);
    }

    @DisplayName("Ball")
    @Test
    void ball() {
        //given
        Computer computer = Computer.createComputer(List.of(1, 2, 3));
        User user = new User(List.of(3, 6, 7));

        //when
        play.playBaseBallGame(computer, user);

        //then
        Assertions.assertThat(user.getStrike()).isEqualTo(0);
        Assertions.assertThat(user.getBall()).isEqualTo(1);
    }

    @DisplayName("Strike")
    @Test
    void strike() {
        //given
        Computer computer = Computer.createComputer(List.of(1, 2, 3));
        User user = new User(List.of(1, 2, 3));

        //when
        play.playBaseBallGame(computer, user);

        //then
        Assertions.assertThat(user.getStrike()).isEqualTo(3);
        Assertions.assertThat(user.getBall()).isEqualTo(0);
    }

    @DisplayName("Ball & Strike")
    @Test
    void ballAndStrike() {
        //given
        Computer computer = Computer.createComputer(List.of(1, 2, 3));
        User user = new User(List.of(1, 3, 7));

        //when
        play.playBaseBallGame(computer, user);

        //then
        Assertions.assertThat(user.getStrike()).isEqualTo(1);
        Assertions.assertThat(user.getBall()).isEqualTo(1);
    }
}