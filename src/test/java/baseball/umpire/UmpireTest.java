package baseball.umpire;

import baseball.AppConfig;
import baseball.game.Score;
import baseball.game.umpire.Umpire;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static baseball.AppConfig.DIGIT_NUM;

public class UmpireTest {

    Umpire umpire;

    @BeforeEach
    public void BeforeEach(){
        AppConfig appConfig = new AppConfig();
        umpire = appConfig.umpire();
    }

    @Test
    void umpireStrikeCheck(){
        //given
        String ball = "123";
        String batt = "153";
        int compareCount = 0;
        Boolean[] strikeCheckingBoard = new Boolean[DIGIT_NUM];
        Arrays.fill(strikeCheckingBoard, false);

        for(int i = 0 ; i < DIGIT_NUM ; i++){
            if(ball.charAt(i) == batt.charAt(i)){
                compareCount++;
            }
        }
        //when
        strikeCheckingBoard = umpire.checkStrike(ball, batt, strikeCheckingBoard);
        //then
        int strikeCount = 0;
        for(int i = 0 ; i < DIGIT_NUM ; i++){
            if(strikeCheckingBoard[i] == true){
                strikeCount++;
            }
        }
        Assertions.assertThat(strikeCount).isEqualTo(compareCount);
    }

    @Test
    void umpireBallCheck(){}

    @Test
    void umpireHomerunCheck(){}

    @Test
    void umpireNothingCheck(){}

    @Test
    void umpireJudgeCheck(){}
}
