package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    Player player = new Player(Note.writeDown("456"));

    @Test
    void Counter_리턴(){
        Assertions.assertEquals("456", player.getGuessNumber().toString()
        );
    }
    @Test
    void String_추측값_입력받기(){
        player.writeGuessNumber(Note.writeDown("123"));
        Assertions.assertEquals("123", player.getGuessNumber().toString());
    }

}
