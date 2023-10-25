package baseball.game;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.result.Result;
import baseball.result.Status;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InningTest {
    static ByteArrayOutputStream outContent;
    static Field result;
    static Method printMethod;
    static Method endInningMethod;

    @BeforeEach
    void beforeEach() throws NoSuchFieldException, NoSuchMethodException {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        result = Inning.class.getDeclaredField("result");
        result.setAccessible(true);

        printMethod = Inning.class.getDeclaredMethod("printResult");
        printMethod.setAccessible(true);

        endInningMethod = Inning.class.getDeclaredMethod("endInning");
        endInningMethod.setAccessible(true);
    }

    @AfterEach
    void afterEach() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("1스트라이크 문구 출력한다.")
    public void 스트라이크1_문구_출력한다() throws IllegalAccessException, InvocationTargetException {
        // given
        Inning inning = new Inning();
        Result testResult = new Result(new Status(0), new Status(1));

        // when
        result.set(inning, testResult);
        printMethod.invoke(inning);

        // then
        String expectedOutput = "1스트라이크" + "\n";
        assertThat(outContent.toString()).contains(expectedOutput);
    }

    @Test
    @DisplayName("1볼 2스트라이크 문구 출력한다.")
    public void 볼1_스트라이크2_문구_출력한다() throws IllegalAccessException, InvocationTargetException {
        // given
        Inning inning = new Inning();
        Result testResult = new Result(new Status(1), new Status(2));

        // when
        result.set(inning, testResult);
        printMethod.invoke(inning);

        // then
        String expectedOutput = "1볼 2스트라이크" + "\n";
        assertThat(outContent.toString()).contains(expectedOutput);
    }

    @Test
    @DisplayName("3볼 문구 출력한다.")
    public void 볼3_문구_출력한다() throws IllegalAccessException, InvocationTargetException {
        // given
        Inning inning = new Inning();
        Result testResult = new Result(new Status(3), new Status(0));

        // when
        result.set(inning, testResult);
        printMethod.invoke(inning);

        // then
        String expectedOutput = "3볼" + "\n";
        assertThat(outContent.toString()).contains(expectedOutput);
    }

    @Test
    @DisplayName("낫싱 문구 출력한다.")
    public void 낫싱_문구_출력한다() throws IllegalAccessException, InvocationTargetException {
        // given
        Inning inning = new Inning();
        Result testResult = new Result(new Status(0), new Status(0));

        // when
        result.set(inning, testResult);
        printMethod.invoke(inning);

        // then
        String expectedOutput = "낫싱" + "\n";
        assertThat(outContent.toString()).contains(expectedOutput);
    }

    @Test
    @DisplayName("3스트라이크 종료 문구 출력한다.")
    public void 스트라이크3_종료_문구_출력한다() throws InvocationTargetException, IllegalAccessException {
        // given
        Inning inning = new Inning();
        Result testResult = new Result(new Status(0), new Status(3));

        // when
        result.set(inning, testResult);
        endInningMethod.invoke(inning);

        // then
        String expectedOutput = "3개의 숫자를 모두 맞히셨습니다! 게임 종료" + "\n";
        assertThat(outContent.toString()).contains(expectedOutput);
    }
}
