package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    static Computer computer = new Computer();

    @Test
    void 랜덤_값_생성_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    computer.makeNumberSet();
                    ;
                },
                1, 3, 3, 1, 5
        );
        computer.makeResult(List.of(1, 3, 5)).equals("3스트라이크");
    }

    @Test
    void 낫싱() {
        assertRandomNumberInRangeTest(
                () -> {
                    computer.makeNumberSet();
                    ;
                },
                1, 3, 5
        );
        computer.makeResult(List.of(2, 4, 6)).equals("낫싱");
    }

    @Test
    void 볼() {
        assertRandomNumberInRangeTest(
                () -> {
                    computer.makeNumberSet();
                    ;
                },
                1, 3, 5
        );
        computer.makeResult(List.of(5, 1, 3)).equals("3볼");
    }

    @Test
    void 볼_스트라이크() {
        assertRandomNumberInRangeTest(
                () -> {
                    computer.makeNumberSet();
                    ;
                },
                1, 3, 5
        );
        computer.makeResult(List.of(1, 5, 3)).equals("1스트라이크 2볼");
    }

}
