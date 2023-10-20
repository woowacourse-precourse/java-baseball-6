package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.*; // 자동 완성 관련 해제하는 방법 알아보기
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IOTest {
    // Input, Output 확인하기
    private PrintStream standardOut;
    private OutputStream captor;
    private InputStream userInputStream;

    @BeforeEach
    void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected String output() {
        return captor.toString();
    }

    protected static InputStream generateMultipleInputsStream(String input, String result) {
        List<InputStream> inputStreams = Arrays.asList(
                generateUserInputStream(input),
                generateUserInputStream(result));
        return new SequenceInputStream(Collections.enumeration(inputStreams));
    }

    protected static InputStream generateUserInputStream(String userInput) {
        return new ByteArrayInputStream(userInput.getBytes());
    }

    protected static void setInUserInput(InputStream userInputStream) {
        System.setIn(userInputStream);
    }

    protected static String generateMultipleInputString(String... values) {
        return String.join("\n", values);
    }

}
