package baseball.model;

import baseball.model.baseball.BaseballManager;
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

}
