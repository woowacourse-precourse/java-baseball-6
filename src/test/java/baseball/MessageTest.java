package baseball;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MessageTest {

    Message message = new Message();

    @Test
    void scoreMessage() {
        List<Integer> score = List.of(0, 0);
        assertEquals("낫싱", message.scoreMessage(score));

        score = List.of(1, 0);
        assertEquals("1볼", message.scoreMessage(score));

        score = List.of(0, 1);
        assertEquals("1스트라이크", message.scoreMessage(score));

        score = List.of(1, 1);
        assertEquals("1볼 1스트라이크", message.scoreMessage(score));

        score = List.of(2, 1);
        assertEquals("2볼 1스트라이크", message.scoreMessage(score));
    }

    @DisplayName("볼, 스트라이크가 0일 경우 낫싱 출력 테스트")
    @Test
    public void nothingMessageTest() {
        List<Integer> nothing = List.of(0, 0);
        String result = message.scoreMessage(nothing);
        assertThat(result).isEqualTo("낫싱");
    }

    @DisplayName("볼만 존제할 경우 볼 출력 테스트")
    @Test
    public void ballMessageTest() {
        List<Integer> ball = List.of(1, 0);
        String result = message.scoreMessage(ball);
        assertThat(result).isEqualTo(ball.get(0) + "볼");
    }

    @DisplayName("스트라이크만 존제할 경우 볼 출력 테스트")
    @Test
    public void strikeMessageTest() {
        List<Integer> strike = List.of(0, 1);
        String result = message.scoreMessage(strike);
        assertThat(result).isEqualTo(strike.get(1) + "스트라이크");
    }

    @DisplayName("볼과 스트라이크가 둘 다 있을 경우 출력 테스트")
    @Test
    public void bothMessageTest() {
        List<Integer> both = List.of(2, 1);
        String result = message.scoreMessage(both);
        assertThat(result).isEqualTo(both.get(0) + "볼 " + both.get(1) + "스트라이크");
    }
}