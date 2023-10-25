package view;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StartTextPrinterTest {

    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams(){
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams(){
        System.setOut(System.out);
    }
    @Test
    @DisplayName("게임이 시작되면 '숫자 야구 게임을 시작합니다.' 라는 문구가 출력되어야한다.")
    void startTest(){
        //given
        StartTextPrinter os = new StartTextPrinter();
        //when
        os.printStartText();
        //then
        Assertions.assertEquals("숫자 야구 게임을 시작합니다.\n", outputMessage.toString());
    }
}
