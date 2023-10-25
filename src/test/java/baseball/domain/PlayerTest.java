package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Player 클래스")
class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    void 유효하지_않은_숫자_설정_시_예외_발생() {
        List<Integer> invalidNumbers = Arrays.asList(0, 2, 3);
        assertThrows(IllegalArgumentException.class, () -> player.setNumbers(invalidNumbers));
    }

}