package baseball.game;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ResultTest extends NsTest {
    @Test
    void 스트라이크만_있을_때() {
        // given
        String message = "2스트라이크";

        // when
        Result result = new Result(2, 0);

        // then
        assertAll(
                () -> assertEquals(result.toString(), message),
                () -> assertFalse(result.isWin())
        );
    }

    @Test
    void 볼만_있을_때() {
        // given
        String message = "3볼";

        // when
        Result result = new Result(0, 3);

        //then
        assertAll(
                () -> assertEquals(result.toString(), message),
                () -> assertFalse(result.isWin())
        );
    }

    @Test
    void 스트라이크와_볼_모두_있을_때() {
        // given
        String message = "2볼 1스트라이크";

        // when
        Result result = new Result(1, 2);

        // then
        assertAll(
                () -> assertEquals(result.toString(), message),
                () -> assertFalse(result.isWin())
        );
    }

    @Test
    void 스트라이크가_3개일_때() {
        // given
        String message = "3스트라이크";

        // when
        Result result = new Result(3, 0);

        // then
        assertAll(
                () -> assertEquals(result.toString(), message),
                () -> assertTrue(result.isWin())
        );
    }

    @Test
    void 결과_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "491", "2");
                    assertThat(output()).contains("1볼", "3스트라이크");
                },
                4, 9, 1
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
