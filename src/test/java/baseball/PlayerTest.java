package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class PlayerTest {
    private Player player;
    @BeforeEach
    private void setUp(){
        player = new Player();
    }
    @Test
    void testGetPlayerInput_사용자의_입력을_받는다(){
        String expectedInput = "123";
        System.setIn(new ByteArrayInputStream(expectedInput.getBytes()));
        var userInput = player.getPlayerInput();
        Assertions.assertEquals(expectedInput,userInput);
    }
    @Test
    void testGetPlayerInput_입력하지_않으면_에러를_발생한다(){
        String expectedInput = "";
        System.setIn(new ByteArrayInputStream(expectedInput.getBytes()));
        IllegalArgumentException exception =
                Assertions.assertThrows(IllegalArgumentException.class,()->player.getPlayerInput());
        Assertions.assertEquals("명령을 입력해주세요!"
                ,exception.getMessage());
    }


}
