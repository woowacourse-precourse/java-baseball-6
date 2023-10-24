package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberBaseballGameTest extends NsTest {
    NumberBaseballGame numberBaseballGame = new NumberBaseballGame();

    @DisplayName("게임 도중 에러 발생 테스트")
    @Test
    public void exceptionDuringGame() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            run("216", "241", "999");
        });
    }

    @DisplayName("볼, 스트라이크 카운트에 대한 테스트")
    @Test
    public void contTest() throws Exception {
        assertRandomNumberInRangeTest(
                () -> {
                    run("216", "891", "273", "916", "378", "2");
                    assertThat(output()).contains("낫싱", "1볼", "1볼 1스트라이크", "낫싱", "3스트라이크");
                },
                3, 7, 8
        );

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
        Console.close();
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
        Console.close();


    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}