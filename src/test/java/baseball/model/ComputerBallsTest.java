package baseball.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ComputerBallsTest extends NsTest {

    @Test
    void 검증_완료_결과() {
        // computer ball을 생성하는데 에러가 발생하지 않음을 예상한다
        assertSimpleTest(ComputerBallsTest::new);
    }

    @Override
    protected void runMain() {
    }
}
