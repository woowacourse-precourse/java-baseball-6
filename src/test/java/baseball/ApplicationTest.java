package baseball;

import baseball.common.Common;
import baseball.service.GameService;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void computerNumbersCountTest() {
        List<Integer> computerNumbers = Common.createComputerNumbers();
        assertThat(computerNumbers).size().isEqualTo(3);
    }

    @Test
    void notDuplicateComputerNumbers() {
        List<Integer> computerNumbers = Common.createComputerNumbers();
        boolean flag = true;
        if (computerNumbers.get(0) == computerNumbers.get(1)) flag = false;
        if (computerNumbers.get(0) == computerNumbers.get(2)) flag = false;
        if (computerNumbers.get(1) == computerNumbers.get(2)) flag = false;
        assertThat(flag).isTrue();
    }

    @Test
    void oneBallcalculateTest() {
        final List<Integer> computers = new ArrayList<>();
        computers.add(1);
        computers.add(2);
        computers.add(3);
        final List<Integer> users = new ArrayList<>();
        users.add(3);
        users.add(4);
        users.add(5);

        int[] result = GameService.calculate(computers, users);

        assertThat(result[1]).isEqualTo(1);
    }
    @Test
    void oneBallOneStrikeCalculateTest() {
        final List<Integer> computers = new ArrayList<>();
        computers.add(1);
        computers.add(2);
        computers.add(3);
        final List<Integer> users = new ArrayList<>();
        users.add(7);
        users.add(1);
        users.add(3);

        int[] result = GameService.calculate(computers, users);

        assertThat(result[0]).isEqualTo(1);
        assertThat(result[1]).isEqualTo(1);
    }

    @Test
    void threeStrikeCalculateTest() {
        final List<Integer> computers = new ArrayList<>();
        computers.add(9);
        computers.add(3);
        computers.add(8);
        final List<Integer> users = new ArrayList<>();
        users.add(9);
        users.add(3);
        users.add(8);

        int[] result = GameService.calculate(computers, users);

        assertThat(result[0]).isEqualTo(3);
    }




    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
