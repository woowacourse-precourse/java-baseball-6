package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballTest {

    Baseball baseball = new Baseball();

    @Test
    void 새로운_정답_생성() {
        List<Integer> answer = baseball.makeNewAnswer();
        assertThat(answer.size()).isEqualTo(3);
    }

    @Test
    void 볼과_스트라이크_카운트() {
        String result = baseball.countBallAndStrike(List.of(1,2,3), "321");
        assertThat(result).isEqualTo("21");
    }

    @Test
    void 게임결과가_03일시_성공() {
        String gameResult = "03";
        boolean flag = baseball.ifSuccess(gameResult);
        assertThat(flag).isEqualTo(true);
    }
}