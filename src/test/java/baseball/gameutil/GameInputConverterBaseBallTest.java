package baseball.gameutil;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameInputConverterBaseBallTest {
    @Test
    void 변환_테스트(){
        //given
        String test = "123";
        GameInputConverter gameInputConverter = new GameInputConverterBaseball();

        //when
        List<Integer> res =  gameInputConverter.convertBaseballStringToList(test);

        //then
        Assertions.assertEquals(List.of(1, 2, 3), res);
    }
}
