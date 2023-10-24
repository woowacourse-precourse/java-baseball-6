package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseballGameTest extends ApplicationTest {
    @ParameterizedTest
    @CsvSource({
            "0",
            "3",
            "q"
    })
    void 재시작_종료_유효성_실패_테스트(String playerChoice) {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThrows(IllegalArgumentException.class,
                            () -> run("246", "135", playerChoice));
                },
                1, 3, 5
        );
    }
}
