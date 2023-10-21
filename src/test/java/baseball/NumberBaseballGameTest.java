package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberBaseballGameTest {

    NumberBaseballGame numberBaseballGame = new NumberBaseballGame();

    @DisplayName("게임 종료를 입력받기 전까지 진행되는 과정")
    @Test
    void play() {
    }

    @DisplayName("3스트라이크를 입력할 때까지 진행되는 과정")
    @Test
    void oneRound() {
    }

    @DisplayName("재시작 입력에 대한 true 반환 테스트")
    @Test
    public void restartOrStopTest() throws Exception {
        //given
        String sign = "1";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(sign.getBytes());
        System.setIn(byteArrayInputStream);
        //when
        boolean result = numberBaseballGame.restartOrStop();
        //then
        assertThat(result).isEqualTo(true);

    }

}