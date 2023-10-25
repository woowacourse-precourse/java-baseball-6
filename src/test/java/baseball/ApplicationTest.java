package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {

    // pickUniqueNumbersInRange 을 사용하였기 때문에 함수 변경하여 test
    @Test
    void Game_End_Restart() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("246", "243", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱","1볼", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                Arrays.asList(1, 3, 5),
                Arrays.asList(5, 8, 9)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
