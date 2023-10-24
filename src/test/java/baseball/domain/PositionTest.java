package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PositionTest {

    @Test
    void Position생성() {
        Position position1 = new Position(1);
        Position position3 = new Position(3);
        assertThat(position1).isEqualTo(new Position(1));
        assertThat(position3).isEqualTo(new Position(3));
    }

    @Test
    void 유효하지않은_Position생성() {
        assertThrows(IllegalArgumentException.class, () -> new Position(0));
        assertThrows(IllegalArgumentException.class, () -> new Position(4));
    }
}