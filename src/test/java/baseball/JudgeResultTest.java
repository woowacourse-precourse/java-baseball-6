package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JudgeResultTest {

    @DisplayName("볼과 스트라이크 카운트를 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "0,3,3스트라이크",
            "0,2,2스트라이크",
            "0,1,1스트라이크",
            "3,0,3볼",
            "2,0,2볼",
            "1,0,1볼",
            "1,2,1볼 2스트라이크",
            "2,2,2볼 2스트라이크",
            "0,0,낫싱"
    }, delimiter = ',')
    void checkJudgeResult(int ball, int strike, String resultMessage) {
        JudgeResult judgeResult = new JudgeResult();
        String message = "낫싱";

        if (ball > 0 && strike > 0) {
            for (int i = 0; i < ball; i++) {
                judgeResult.incrementBall();
            }
            for (int i = 0; i < strike; i++) {
                judgeResult.incrementStrike();
            }
            message = String.format("%d볼 %d스트라이크", judgeResult.getBall(), judgeResult.getStrike());
        }

        if (ball > 0 && strike == 0) {
            for (int i = 0; i < ball; i++) {
                judgeResult.incrementBall();
            }
            message = String.format("%d볼", judgeResult.getBall());
        }

        if (ball == 0 && strike > 0) {
            for (int i = 0; i < strike; i++) {
                judgeResult.incrementStrike();
            }
            message = String.format("%d스트라이크", judgeResult.getStrike());
        }
        System.out.println(message);
        assertThat(message).isEqualTo(resultMessage);
    }

}