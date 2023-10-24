package baseball.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;


class GameIOTest extends NsTest {
    GameIO gameIO = new GameIO();
    @Test
    void 숫자_비교_결과가_3스트라이크면_해당_내용_출력(){

        Map<String, Integer> compareResult = new HashMap<>();
        compareResult.put("strike", 3);
        compareResult.put("balls", 0);

        gameIO.printBallStrike(compareResult);
        assertThat(output()).contains("3스트라이크");

    }

    @Override
    protected void runMain() {

    }
}