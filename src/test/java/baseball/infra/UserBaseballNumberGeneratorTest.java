package baseball.infra;

import baseball.domain.BaseballNumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

public class UserBaseballNumberGeneratorTest {
    BaseballNumberGenerator baseballNumberGenerator = new UserBaseballNumberGenerator();

    @Test
    @DisplayName("")
    public void testThrowExceptionWhenDuplicateNumber() throws IOException {
        String input = "122\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);


        Assertions.assertThrows(IllegalArgumentException.class, () -> baseballNumberGenerator.generateBaseballNumber(3));

        System.in.reset();
        System.in.close();
    }

    @Test
    @DisplayName("")
    public void testThrowExceptionWhenInvalidLength() throws IOException {
        String input = "1223\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

//        BaseballNumberGenerator baseballNumberGenerator = new UserBaseballNumberGenerator();

        Assertions.assertThrows(IllegalArgumentException.class, () -> baseballNumberGenerator.generateBaseballNumber(3));
        System.in.reset();
        System.in.close();
    }
}
