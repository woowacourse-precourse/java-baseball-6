package baseball;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberBaseballGameTest {

    NumberBaseballGame numberBaseballGame = new NumberBaseballGame();

    /*
     * Application을 분석해보자..!!!!
     *run -> command 호출해서 args 받고, setIn 역할을 해준다.
     *이러면 유저가 입력한 값들이 되는군.
     * output?
     * */
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
    public void restartTest() throws Exception {
        //given
        String sign = "1";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(sign.getBytes());
        System.setIn(byteArrayInputStream);
        Method method = numberBaseballGame.getClass().getDeclaredMethod("restartOrStop");
        method.setAccessible(true);
        //when
        boolean result = (boolean) method.invoke(numberBaseballGame);
        //then
        assertThat(result).isEqualTo(true);

    }

    @DisplayName("종료 입력에 대한 false 반환 테스트")
    @Test
    public void stopTest() throws Exception {
        //given
        String sign = "2";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(sign.getBytes());
        System.setIn(byteArrayInputStream);
        Method method = numberBaseballGame.getClass().getDeclaredMethod("restartOrStop");
        method.setAccessible(true);
        //when
        boolean result = (boolean) method.invoke(numberBaseballGame);
        //then
        assertThat(result).isEqualTo(false);

    }

}