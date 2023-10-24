package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    Computer instance1 = Computer.getInstance();
    GameImplementation game1 = new GameImplementation();

    @Test
    void testSingletonComputer(){
        Computer instance2 = Computer.getInstance();
        assertThat(instance1.equals(instance2));
    }

    @Test
    void testMakeAnswer(){
        List<Integer> answer= instance1.makeNewAnswer();
        assertThat(answer.size()).isEqualTo(3);
        assertThat(answer.size()).isNotEqualTo(4);

    }

    @Test
    void testMakePlayerAnswer(){
        game1.setPlayerAnswer("123");
        game1.makePlayerAnswerToList();
        List<Integer> answer=game1.getPlayerAnswerList();

        assertThat(answer).isEqualTo(Arrays.asList(1, 2, 3));
        assertThat(answer).isNotEqualTo(Arrays.asList(1, 2, 4));
    }


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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
