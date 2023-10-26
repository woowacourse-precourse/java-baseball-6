package baseball.message;

import static baseball.message.Message.BALL_MSG;
import static baseball.message.Message.END_MSG;
import static baseball.message.Message.INPUT_MSG;
import static baseball.message.Message.NON_MSG;
import static baseball.message.Message.REGAME_MSG;
import static baseball.message.Message.START_MSG;
import static baseball.message.Message.STRIKE_MSG;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MessageTest {

    @Test
    void msgCheck() {
        assertThat(START_MSG).isEqualTo("숫자 야구 게임을 시작합니다.");
        assertThat(END_MSG).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        assertThat(REGAME_MSG).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        assertThat(NON_MSG).isEqualTo("낫싱");
        assertThat(BALL_MSG).isEqualTo("볼");
        assertThat(STRIKE_MSG).isEqualTo("스트라이크");
        assertThat(INPUT_MSG).isEqualTo("숫자를 입력해주세요 : ");

    }

}