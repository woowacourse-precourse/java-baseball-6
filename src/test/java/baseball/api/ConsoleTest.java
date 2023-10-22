package baseball.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.Console;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleTest {
    @Test
    @DisplayName("사용자 입력값을 읽어옵니다.")
    public void testReadLine() throws Exception{
        // GIVEN
        /*
        아래 방법을 사용하려 했는데 Scanner가 내장되어있어 해당 방법을 시도 하지 못 했습니다.

        String input = "1";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);*/

        // WHEN

        // THEN

    }

    @Test
    @DisplayName("Console의 메모리 해제합니다.")
    public void testClose() throws Exception{
        // GIVEN
        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        // WHEN
        Console.close();

        // THEN
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        assertThat(usedMemoryBefore).isEqualTo(usedMemoryAfter);
        System.gc();

    }
}
