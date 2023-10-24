package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IOTest {
    private final ByteArrayOutputStream captor = new ByteArrayOutputStream();

    @BeforeEach
    void init() {
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void printOutput() {
        System.setOut(System.out);
        System.out.println(output());
        captor.reset();
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

    protected static String generateMultipleInputString(String... values) {
        return String.join("\n", values);
    }

    protected static void setInUserInput(InputStream userInputStream) {
        System.setIn(userInputStream);
    }

    protected String output() {
        return captor.toString();
    }
}
