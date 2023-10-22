package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputConsoleTest {
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @Test
    void 볼스트라이크_출력(){
        OutputConsole outputConsole = new OutputConsole();

        outputConsole.printResult(1, 2);
        outputConsole.printResult(0, 0);
        outputConsole.printResult(1, 0);
        outputConsole.printResult(0, 2);

        assertEquals("1볼 2스트라이크\n낫싱\n1볼\n2스트라이크\n", outputMessage.toString());
    }
}