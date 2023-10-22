package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    Player player = Player.enterGuess(Count.provideCount("123"));
    @Test
    void Counter_리턴(){
        Assertions.assertEquals("456", player.getCount());
    }
    @Test
    void String_추측값_입력받기(){
        player.enterGuess(Count.provideCount("123"));
        Assertions.assertEquals("123", player.getCount());
    }

}
