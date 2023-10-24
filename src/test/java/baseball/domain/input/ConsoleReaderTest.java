package baseball.domain.input;

import baseball.domain.input.ConsoleReader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.Console.close;

class ConsoleReaderTest {

    @BeforeEach
    void setup() {
        String input = "test input";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @AfterEach
    void consoleClose() {
        close();
    }

    @Test
    void 콘솔_입력_성공_테스트() {
        // given & when
        String userInput = ConsoleReader.input();

        // then
        Assertions.assertThat(userInput).isEqualTo("test input");
    }

    @Test
    void 콘솔_입력_실패_테스트() {
        // given & when
        String userInput = ConsoleReader.input();

        // then
        Assertions.assertThat(userInput).isNotEqualTo("우테코");
    }

}