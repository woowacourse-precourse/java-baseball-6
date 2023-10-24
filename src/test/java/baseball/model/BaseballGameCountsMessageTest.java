package baseball.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameCountsMessageTest {
    @Test
    @DisplayName("1볼 1스트라이크 메시지를 생성 후 출력한다.")
    public void 메시지_1볼_1스트라이크_테스트() throws Exception {
        // given
        ComputerNumber computer = new ComputerNumber("123");

        UserNumber user = new UserNumber("136");

        BaseballGameCountsMessage message = new BaseballGameCountsMessage(new BaseballGameCounts(computer, user));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // when
        message.printMessage();

        // then
        String expectedOutput = "1볼 1스트라이크";
        String actualOutput = output.toString().trim();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("3볼 메시지를 생성 후 출력한다.")
    public void 메시지_3볼_테스트() throws Exception {
        // given
        ComputerNumber computer = new ComputerNumber("123");

        UserNumber user = new UserNumber("312");

        BaseballGameCountsMessage message = new BaseballGameCountsMessage(new BaseballGameCounts(computer, user));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // when
        message.printMessage();

        // then
        String expectedOutput = "3볼";
        String actualOutput = output.toString().trim();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("3스트라이크 메시지를 생성 후 출력한다.")
    public void 메시지_3스트라이크_테스트() throws Exception {
        // given
        ComputerNumber computer = new ComputerNumber("123");

        UserNumber user = new UserNumber("123");

        BaseballGameCountsMessage message = new BaseballGameCountsMessage(new BaseballGameCounts(computer, user));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // when
        message.printMessage();

        // then
        String expectedOutput = "3스트라이크";
        String actualOutput = output.toString().trim();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("낫싱 메시지를 생성 후 출력한다.")
    public void 메시지_낫싱_테스트() throws Exception {
        // given
        ComputerNumber computer = new ComputerNumber("123");

        UserNumber user = new UserNumber("456");

        BaseballGameCountsMessage message = new BaseballGameCountsMessage(new BaseballGameCounts(computer, user));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // when
        message.printMessage();

        // then
        String expectedOutput = "낫싱";
        String actualOutput = output.toString().trim();
        assertEquals(expectedOutput, actualOutput);
    }

}