package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class BaseballGameResultTest {

    @Test
    void 결과_계산_볼_하나_스트라이크_하나() {
        List<Integer> computerNumbs = List.of(3, 5, 2);
        String input = "251";

        BaseballGameResult gameResult = new BaseballGameResult(computerNumbs, new UserNumber(input));
        assertThat(gameResult.ballCount).isEqualTo(1);
        assertThat(gameResult.strikeCount).isEqualTo(1);
    }

    @Test
    void 결과_계산_볼_하나_스트라이크_없음() {
        List<Integer> computerNumbs = List.of(3, 5, 2);
        String input = "241";

        BaseballGameResult gameResult = new BaseballGameResult(computerNumbs, new UserNumber(input));
        assertThat(gameResult.ballCount).isEqualTo(1);
        assertThat(gameResult.strikeCount).isZero();
    }

    @Test
    void 결과_계산_볼_둘_스트라이크_없음() {
        List<Integer> computerNumbs = List.of(3, 5, 2);
        String input = "231";

        BaseballGameResult gameResult = new BaseballGameResult(computerNumbs, new UserNumber(input));
        assertThat(gameResult.ballCount).isEqualTo(2);
        assertThat(gameResult.strikeCount).isZero();
    }

    @Test
    void 결과_계산_볼_없음_스트라이크_셋() {
        List<Integer> computerNumbs = List.of(3, 5, 2);
        String input = "352";

        BaseballGameResult gameResult = new BaseballGameResult(computerNumbs, new UserNumber(input));
        assertThat(gameResult.ballCount).isZero();
        assertThat(gameResult.strikeCount).isEqualTo(3);
    }

    @Test
    void 결과_계산_볼_셋_스트라이크_없음() {
        List<Integer> computerNumbs = List.of(3, 5, 2);
        String input = "523";

        BaseballGameResult gameResult = new BaseballGameResult(computerNumbs, new UserNumber(input));
        assertThat(gameResult.ballCount).isEqualTo(3);
        assertThat(gameResult.strikeCount).isZero();
    }
}
