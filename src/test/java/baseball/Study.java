package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class Study {
    private ByteArrayOutputStream outputStreamCaptor;

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    void test() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
    }

    protected String getOutput() {
        // ByteArrayOutputStream의 toString은 기본 문자집합을 사용하여 버퍼의 내용을 문자열 디코딩 바이트로 변환해줍니다.
        return outputStreamCaptor.toString();
    }

    @Test
    void set_in_test() {
        systemIn("원하는 입력값");
        test();

        assertThat(getOutput()).contains("원하는 1입력값");
    }
}
