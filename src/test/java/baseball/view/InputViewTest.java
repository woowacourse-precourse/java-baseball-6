package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    @DisplayName("단순 입력 테스트")
    void inputTest() {
        // given
        String input = "test";
        String result = null;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputStream in = System.in;
        try {
            byte[] buffer = new byte[4096];
            int a = in.read(buffer, 0, 4096);
            String strByte = new String(buffer);
            result = strByte.trim();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat(input).isEqualTo(result);
        System.out.println("result = " + result);

    }

    @Test
    @DisplayName("Scanner 입력 테스트")
    void inputScannerTest() {
        // given
        String input = "test";
        String result = null;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        assertThat(input).isEqualTo(scanner.nextLine());

    }

    @Test
    @DisplayName("사용자 출력값 테스트")
    public void outputTest() {
        // given
        String output = "test";
        PrintStream standardOut = System.out;
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteOutput));

        System.out.println(output);

        System.setOut(standardOut);
        String result = byteOutput.toString().trim();
        System.out.println("result = " + result);
        assertThat(output).isEqualTo(result);

    }

}