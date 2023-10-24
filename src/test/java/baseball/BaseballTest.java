package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.app.Baseball;
import baseball.domain.Player;
import baseball.domain.RandomNumber;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BaseballTest {

    @Test
    void 랜덤_숫자_출력() {
        RandomNumber rn = new RandomNumber();
        assertThat(rn.make().size()).isEqualTo(3);
    }

    @Test
    void 세자리_숫자_간_비교결과_출력() {
        Baseball baseball = new Baseball();
        List<Integer> num1 = Arrays.asList(1, 2, 3);
        List<Integer> num2 = Arrays.asList(3, 4, 3);
        baseball.compare(num1, num2);

        assertThat(baseball.getResult()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 플레이어_숫자_입력() {
        Player player = new Player();
//        player.inputNum();
    }
}
