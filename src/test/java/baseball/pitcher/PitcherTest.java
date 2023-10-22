package baseball.pitcher;

import baseball.AppConfig;
import baseball.game.pitcher.Pitcher;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static baseball.AppConfig.DIGIT_NUM;

public class PitcherTest {

    Pitcher pitcher;

    @BeforeEach
    public void BeforeEach(){
        AppConfig appConfig = new AppConfig();
        pitcher = appConfig.pitcher();
    }

    @Test
    void pitcherPitchTest(){
        //given
        String outputNum = "";
        //when
        outputNum = pitcher.pitch();
        //then
        Assertions.assertThat(outputNum.length()).isEqualTo(DIGIT_NUM);
    }
}
