package baseball.gameutil;

import baseball.gameutil.converter.GameInputConverter;
import baseball.gameutil.converter.GameInputConverterBaseball;
import baseball.gameutil.validate.InputMod;
import baseball.io.Input;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameInputConverterBaseBallTest {

    @Test
    void 변환_테스트(){
        //given
        String test = "123";

        Input input = () -> test;
        GameInputConverter gameInputConverter = new GameInputConverterBaseball(input);


        //when
        List<Integer> res =  gameInputConverter.convertBaseballInput(InputMod.GAME);
        //then
        Assertions.assertEquals(List.of(1, 2, 3), res);
    }
}
