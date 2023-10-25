package baseball.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.util.DefaultRandomNumberCreatorByDigit;
import org.junit.jupiter.api.Test;

class RandomNumberCreatorTest {

    @Test
    public void 세자리_정수를_생성한다() {
        Integer integer = new DefaultRandomNumberCreatorByDigit().create(3);

        assertEquals(3, integer.toString().length());
    }

}