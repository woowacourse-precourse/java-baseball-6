package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {

    @Test
    void 숫자_입력_테스트() {
        InputStream in = new ByteArrayInputStream("123".getBytes());
        System.setIn(in);
        List<Integer> list = DisplayBoard.inputNumbers();
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(2);
        assertThat(list.get(2)).isEqualTo(3);
    }

    @Test
    void 야구_게임_매칭_테스트() throws NoSuchFieldException, IllegalAccessException {
        BallUtils ballUtils = new BallUtils();
        Field field = BallUtils.class.getDeclaredField("computer");
        field.setAccessible(true);
        field.set(ballUtils, List.of(1, 2, 3));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(outputStream);
        System.setOut(newOut);
        ballUtils.compareBalls(List.of(1, 4, 5));
        assertThat(outputStream.toString().trim()).isEqualTo("1스트라이크");
        outputStream.reset();
        ballUtils.compareBalls(List.of(2, 4, 5));
        assertThat(outputStream.toString().trim()).isEqualTo("1볼");
        outputStream.reset();
        ballUtils.compareBalls(List.of(2, 4, 3));
        assertThat(outputStream.toString().trim()).isEqualTo("1볼 1스트라이크");
        outputStream.reset();
        ballUtils.compareBalls(List.of(4, 5, 6));
        assertThat(outputStream.toString().trim()).isEqualTo("낫싱");
    }

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
