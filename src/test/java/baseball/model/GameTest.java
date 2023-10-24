package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
        game.setUserNumbers(game.getComputerGameNumbers().getNumbers());
    }

    @Test
    @DisplayName("게임 판단 후 알맞은 결과를 낸다.")
    public void 게임_판단_후_알맞은_결과를_낸다() {
        //given
        game.play();

        //when
        Result result = game.getResult();

        //then
        assertThat(result.toString()).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("게임 판단이 완료된 후 진행 상태를 판단한다.")
    public void 게임_판단이_완료된_후_진행_상태를_판단한다() {
        //given
        game.play();

        //when
        boolean isRunning = game.isRunning();

        //then
        assertThat(isRunning).isFalse();
    }
}
