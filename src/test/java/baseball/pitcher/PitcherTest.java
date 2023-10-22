package baseball.pitcher;

import baseball.AppConfig;
import baseball.game.pitcher.Pitcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PitcherTest {

    Pitcher pitcher;

    @BeforeEach
    public void BeforeEach(){
        AppConfig appConfig = new AppConfig();
        pitcher = appConfig.pitcher();
    }

    @Test
    void pitcherPitchTest(){

    }
}
