package baseball.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void checkNumberSuccess() {
        //given
        String input = "123";
        Player player = new Player();

        //when
        boolean result = player.isRandomNumbers(input);

        //then
        Assertions.assertEquals(true, result);
    }
}