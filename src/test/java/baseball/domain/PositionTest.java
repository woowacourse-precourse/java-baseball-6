package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionTest {

    @Test
    void Position_VO_생성() {
        Position position = new Position(1);
        assertThat(position.getPositionNum()).isEqualTo(1);
    }

    @Test
    void Position_VO_동등성() {
        Position position = new Position(1);
        assertThat(position).isEqualTo(new Position(1));
    }
}
