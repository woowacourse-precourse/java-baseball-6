package baseball.gameutil;

import baseball.io.ConsoleInput;
import baseball.io.Input;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class GameInputConverterBaseBallTest {

    @BeforeEach
    void setUpIO() {
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void 변환_테스트(){
        //given
        String test = "123";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
        Input input = new ConsoleInput();

        GameInputConverter gameInputConverter = new GameInputConverterBaseball(input);


        //when
        List<Integer> res =  gameInputConverter.convertBaseballInput(3);
        //then
        Assertions.assertEquals(List.of(1, 2, 3), res);
    }
}
