package baseball;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberBaseballGameTest {

    @DisplayName("종료 입력에 대한 false 반환 테스트")
    @Test
    public void stopTest() throws Exception {
        NumberBaseballGame numberBaseballGame = new NumberBaseballGame();

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
        Console.close();
    }

    @DisplayName("재시작 입력에 대한 true 반환 테스트")
    @Test
    public void restartTest() throws Exception {
        NumberBaseballGame numberBaseballGame = new NumberBaseballGame();

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
        Console.close();


    }


}