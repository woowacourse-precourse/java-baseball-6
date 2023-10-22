package baseball.constant;

import static baseball.constant.Message.BALL;
import static baseball.constant.Message.INIT;
import static baseball.constant.Message.INPUT;
import static baseball.constant.Message.NOTHING;
import static baseball.constant.Message.RETRY;
import static baseball.constant.Message.STRIKE;
import static baseball.constant.Message.WIN;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MessageTest {

    @Test
    void 각_Enum의_내용_일치() {
        // given
        String initMessage = "숫자 야구 게임을 시작합니다.";
        String inputMessage = "숫자를 입력해주세요 : ";
        String ballMessage = "볼";
        String strikeMessage = "스트라이크";
        String nothingMessage = "낫싱";
        String winMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        String retryMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

        // then
        assertAll(
                () -> assertEquals(initMessage, INIT.getValue()),
                () -> assertEquals(inputMessage, INPUT.getValue()),
                () -> assertEquals(ballMessage, BALL.getValue()),
                () -> assertEquals(strikeMessage, STRIKE.getValue()),
                () -> assertEquals(nothingMessage, NOTHING.getValue()),
                () -> assertEquals(winMessage, WIN.getValue()),
                () -> assertEquals(retryMessage, RETRY.getValue())
        );
    }

}
