package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HintTest {


    @Test
    public void hint() throws Exception {
        Number number = Number.parseNumber(123);
        Number o = Number.parseNumber(134);
        Hint hint = number.getHint(o);

        String s = hint.toString();
        System.out.println(s);
        Assertions.assertTrue(s.contains("1볼 1스트라이크"));
    }

}