package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.model.Result;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RefereeTest {

    @DisplayName("심판 결과 2볼 1스트라이크")
    @Test
    void RefereeResult2ball1strike() {
        Referee referee = new Referee();
        Result result = referee.compare(Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 2));

        assertEquals("2볼 1스트라이크", result.toString());
    }
}
