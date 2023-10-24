package baseball;

import baseball.View.BaseballGame;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserInputTest {

    BaseballGame baseballGame = new BaseballGame();

    @Test
    @Order(1)
    void 게임_클리어유저_입력_정상() {
        String simulatedUserInput = "2\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(inputStream);

        try {
            int result = baseballGame.readEndUserInput();
            assertEquals(2, result);
        } catch (Exception e) {
            fail("예외가 발생했습니다: " + e.getMessage());
        }
    }
    @Test
    @Order(2)
    void 게임_클리어유저_입력_문자오류() {
        String simulatedUserInput = "test\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(inputStream);

        assertThrows(IllegalArgumentException.class, () -> {
            baseballGame.readEndUserInput();
        });
    }
    @Test
    @Order(3)
    void 게임_클리어유저_입력_숫자오류() {
        String simulatedUserInput = "4\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(inputStream);

        assertThrows(IllegalArgumentException.class, () -> {
            baseballGame.readEndUserInput();
        });
    }



}
