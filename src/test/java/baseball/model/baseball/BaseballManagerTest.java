package baseball.model.baseball;

import baseball.model.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BaseballManagerTest {

    BaseballManager baseballManager = new BaseballManager();

    @Test
    @DisplayName("초기 상태는 볼과 스트라이크가 0이다.")
    void check_init_BaseballManager(){
        //when
        String statusBallAndStrike = baseballManager.statusBallAndStrike();

        //then
        assertThat(statusBallAndStrike).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("볼과 스트라이크 개수를 업데이트 한다.")
    void update_ball_and_strike(){
        //given
        Player player = new Player();
        player.updateExpectedNumbers("123");

        //when
        baseballManager.updateBallAndStrike(player);
        String statusBallAndStrike = baseballManager.statusBallAndStrike();

        //then
        assertThat(statusBallAndStrike).containsAnyOf("낫싱", "1볼", "2볼", "3볼"
                , "1볼 1스트라이크", "1볼 2스트라이크", "2볼 1스트라이크"
                , "1스트라이크", "2스트라이크", "3스트라이크");
    }
}
