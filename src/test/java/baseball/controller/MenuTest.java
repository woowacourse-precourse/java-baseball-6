package baseball.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {

    @DisplayName("사용자 메뉴 입력 판별: 재시작")
    @Test
    public void MenuTest() throws Exception {
        //given
        String restartInput = "1";
        String exitInput = "2";
        //when
        boolean restartResult = Menu.restart(restartInput);
        boolean exitResult = Menu.restart(exitInput);
        //then
        Assertions.assertThat(restartResult).isTrue();
        Assertions.assertThat(exitResult).isFalse();
    }

}