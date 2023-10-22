package baseball.domain;

import baseball.dto.GameStatus;
import baseball.dto.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    @DisplayName("3스트라이크인 경우")
    void getScore3Strike() {
        //given
        Computer computer = new Computer(List.of(1, 2, 3));

        //when
        Score score = computer.getScore(List.of(1, 2, 3));

        //then
        assertThat(score.getStrike()).isEqualTo(3);
        assertThat(score.getBall()).isEqualTo(0);
        assertThat(score.getStatus()).isEqualTo(GameStatus.END);
    }


    @Test
    @DisplayName("낫싱인 경우")
    void getScoreNothing() {
        //given
        Computer computer = new Computer(List.of(1, 2, 3));

        //when
        Score score = computer.getScore(List.of(4, 5, 6));

        //then
        assertThat(score.getStrike()).isEqualTo(0);
        assertThat(score.getBall()).isEqualTo(0);
        assertThat(score.getStatus()).isEqualTo(GameStatus.PLAY);
    }


    @Test
    @DisplayName("3볼인 경우")
    void getScore3Ball() {
        //given
        Computer computer = new Computer(List.of(1, 2, 3));

        //when
        Score score = computer.getScore(List.of(2, 3, 1));

        //then
        assertThat(score.getStrike()).isEqualTo(0);
        assertThat(score.getBall()).isEqualTo(3);
        assertThat(score.getStatus()).isEqualTo(GameStatus.PLAY);
    }


    @Test
    @DisplayName("스트라이크와 볼이 동시에 존재하는 경우")
    void getScore() {
        //given
        Computer computer = new Computer(List.of(1, 2, 3));

        //when
        Score score = computer.getScore(List.of(2, 4, 3));

        //then
        assertThat(score.getStrike()).isEqualTo(1);
        assertThat(score.getBall()).isEqualTo(1);
        assertThat(score.getStatus()).isEqualTo(GameStatus.PLAY);
    }
}