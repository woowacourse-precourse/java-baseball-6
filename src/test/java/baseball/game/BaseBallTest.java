package baseball.game;

import baseball.domain.BaseBall;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallTest {

    @DisplayName("난수를 생성할 때 숫자 3자리가 올바르게 생성되어야 한다.")
    @RepeatedTest(10)
    void 게임실행_테스트() {
        BaseBall baseBall = new BaseBall();
        List<Integer> inputBallNumber = baseBall.getInputBallNumber();

        assertThat(inputBallNumber.size()).isEqualTo(3);
    }

    @DisplayName("난수를 생성할 때 숫자 3자리가 중복된 숫자가 아니어야 한다.")
    @RepeatedTest(10)
    void 게임실행_난수생성_테스트() {
        BaseBall baseBall = new BaseBall();
        List<Integer> inputBallNumber = baseBall.getInputBallNumber();
        TreeSet<Integer> treeSet = new TreeSet<>(inputBallNumber);

        assertThat(treeSet.size()).isEqualTo(3);
    }
}
