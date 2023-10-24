package baseball;

import org.junit.jupiter.api.BeforeAll;

public class PlayerTest {
    static Player player;

    @BeforeAll
    static void setup() {
        player = new Player();
    }

}
