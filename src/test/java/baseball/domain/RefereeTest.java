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
    void 스트라이크_개수를_올바르게_계산() {
        referee.calculateStrikeCount(user, computer);
        assertEquals(3, referee.getStrike());
    }

    @Test
    void 볼_개수를_올바르게_계산() {
        computer = new Player(Arrays.asList(2, 3, 1));
        referee.calculateBallCount(user, computer);
        assertEquals(3, referee.getBall());
    }

    @Test
    void 스트라이크가_세_개면_게임이_종료() {
        referee.calculateStrikeCount(user, computer);
        assertEquals(GameStatus.END, referee.isGameEnd());
    }
}