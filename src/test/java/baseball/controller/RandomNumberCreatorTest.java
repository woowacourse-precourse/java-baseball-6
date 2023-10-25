package baseball.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.util.RandomNumberCreator;
import org.junit.jupiter.api.Test;

class RandomNumberCreatorTest {

    @Test
    public void 세자리_정수를_생성한다() {
        Integer integer = RandomNumberCreator.create(3);

        assertEquals(3, integer.toString().length());
    }

}