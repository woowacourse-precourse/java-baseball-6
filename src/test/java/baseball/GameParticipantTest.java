package baseball;

import org.junit.jupiter.api.BeforeEach;

public class GameParticipantTest {
    private GameStatusCode gameStatusCode;

    @BeforeEach
    void setUp() {
        this.gameStatusCode = GameStatusCode.PLAYING;
    }

}
