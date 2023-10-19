package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
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
//    @Test
//    void getComputerNumbersList_테스트() {
//        //given
//        //when
//        List<Integer> computerNumbersList = Application.getComputerNumbersList();
//        System.out.println(computerNumbersList);
//        //then
//        assertThat(computerNumbersList).hasSize(3).doesNotHaveDuplicates()
//                .allMatch(i -> i > 0 && i < 10);
//    }
//    @Test
//    void getUserNumbersList_정상작동_테스트() {
//        //given
//        String input = "123";
//        InputStream originalSystemIn = System.in;
//        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
//        System.setIn(inputStream);
//        //when
//        List<Integer> userNumbersList = Application.getUserNumbersList();
//        //then
//        assertThat(userNumbersList).containsExactly(1,2,3);
//        System.setIn(originalSystemIn);
//    }
//    @Test
//    void getUserNumbersList_예외상황_테스트() {
//        //given
//        String input = "11123";
//        InputStream originalSystemIn = System.in;
//        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
//        System.setIn(inputStream);
//        //when
//        Throwable thrown = catchThrowable(Application::getUserNumbersList);
//        //then
//        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("[ERROR]");
//        System.setIn(originalSystemIn);
//    }
//    @Test
//    void getBallStrikeCount_테스트() {
//        //given
//        List<Integer> computerNumbersList = Arrays.asList(1,2,3);
//        List<Integer> userNumbersList = Arrays.asList(4,5,6);
//        //when
//        List<Integer> strikeBallCount = Application.getBallStrikeCount(computerNumbersList, userNumbersList);
//        //then
//        assertThat(strikeBallCount).containsExactly(0,0);
//    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
