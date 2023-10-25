package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Referee 클래스")
class RefereeTest {

    private Referee referee = Referee.getInstance();
    private Player user;
    private Player computer;

    @BeforeEach
    void setup() {
        user = new Player(Arrays.asList(1, 2, 3));
        computer = new Player(Arrays.asList(1, 2, 3));
    }

    @Test
    void 스트라이크_개수를_올바르게_계산(){
        referee.calculateStrikeCount(user.getNumbers(), computer.getNumbers());
        assertEquals(3, referee.getStrike());
    }
}