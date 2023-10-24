package baseball;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameParticipantTest {
    private GameStatus gameStatus;
    @BeforeEach
    void setUp(){
        this.gameStatus = GameStatus.PLAYING;
    }

}
