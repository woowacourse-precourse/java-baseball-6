package baseball.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.constants.BaseballRole.GAME_EXIT;
import static org.assertj.core.api.Assertions.*;

class BaseballRoleTest {

    @Test
    @DisplayName("게임 종료 입력을 했는지 확인한다.")
    void check_game_exit(){
        //when
        boolean isGameExit = BaseballRole.isGameExit(GAME_EXIT.getValue());

        //then
        assertThat(isGameExit).isTrue();
    }



}
