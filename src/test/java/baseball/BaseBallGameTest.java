package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallGameTest {

    private BaseBallGame baseBallGame;

    @BeforeEach
    void init() {
        this.baseBallGame = new BaseBallGame();
    }

    @DisplayName("게임 메시지가 비어있으면 낫싱을 반환한다.")
    @Test
    void checkMessageNothing() {
        String expect = MessageList.NOTHING;
        String actual = baseBallGame.checkMessage(MessageList.NO_COUNT);
        assertThat(actual.equals(expect));
    }

    @DisplayName("3스트라이크이면 축하메시지를 반환한다.")
    @Test
    void checkMessageAllCorrect() {
        String expect = MessageList.ALL_CORRECT;
        String actual = baseBallGame.checkMessage(MessageList.setStrikeMessage(3));
        assertThat(actual.equals(expect));
    }

    @DisplayName("스트라이크 개수를 반환한다.")
    @Test
    void countStrike() {
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> inputNumbers = Arrays.asList(1, 2, 4);
        int actual = baseBallGame.countStrike(computer, inputNumbers);
        assertThat(actual).isEqualTo(2);
    }

    @DisplayName("볼 개수를 반환한다.")
    @Test
    void countBall() {
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> inputNumbers = Arrays.asList(3, 2, 1);
        int actual = baseBallGame.countBall(computer, inputNumbers);
        assertThat(actual).isEqualTo(2);
    }
}
