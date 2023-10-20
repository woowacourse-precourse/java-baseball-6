package baseball.infra;

import baseball.domain.BaseballNumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

public class UserBaseballNumberGeneratorTest {

    @Test
    @DisplayName("")
    public void testThrowExceptionWhenDuplicateNumber() {
        String input = "122";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        BaseballNumberGenerator baseballNumberGenerator = new UserBaseballNumberGenerator();

        Assertions.assertThrows(IllegalArgumentException.class, () -> baseballNumberGenerator.generateBaseballNumber(3));
    }

    @Test
    @DisplayName("")
    public void testThrowExceptionWhenInvalidLength() {
        String input = "1223";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        BaseballNumberGenerator baseballNumberGenerator = new UserBaseballNumberGenerator();

        Assertions.assertThrows(IllegalArgumentException.class, () -> baseballNumberGenerator.generateBaseballNumber(3));
    }

    @Test
    @DisplayName("")
    public void testValidNumber() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        BaseballNumberGenerator baseballNumberGenerator = new UserBaseballNumberGenerator();
        List<Integer> baseballNumbers = baseballNumberGenerator.generateBaseballNumber(3);

        for (int i = 0; i < input.length(); i++) {
            Assertions.assertEquals((int)input.charAt(i), baseballNumbers.get(i));
        }
    }
}
