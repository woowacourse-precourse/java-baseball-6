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

    @Test
    @DisplayName("게임 재시작 입력을 1 혹은 2로 하지 않았을 때 에러가 발생한다.")
    void input_game_exit_error(){
        assertThatThrownBy(() -> BaseballRole.isGameExit(3))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
