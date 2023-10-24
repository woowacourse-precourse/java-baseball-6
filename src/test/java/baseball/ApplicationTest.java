package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.utils.RandomUtil;
import baseball.model.NumberModel;
import baseball.service.GameService;

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
    void 게임종료_후_종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 비교결과_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("234", "576", "983", "519", "589", "2");
                    assertThat(output()).contains("낫싱", "1볼", "1볼 1스트라이크", "2스트라이크", "3스트라이크");
                },
                5, 8, 9
        );
    }

    @Test
    void 숫자_비교_테스트() {
        List<Integer> answer = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> userNum = new ArrayList<>(Arrays.asList(1, 3, 4));
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 1));

        NumberModel numberModel = new NumberModel();
        numberModel.setComputerNumbers(answer);
        numberModel.setUserNumbers(userNum);
        GameService gameService = new GameService(numberModel);

        assertThat(gameService.compareNumbers()).isEqualTo(expected);
    }

    @Test
    void 사용자입력_저장_테스트() {
        RandomUtil randomUtil = new RandomUtil();
        List<Integer> randomInput = randomUtil.createRandomList();
        NumberModel numberModel = new NumberModel();

        numberModel.setUserNumbers(randomInput);
        assertThat(numberModel.getUserNumbers()).isEqualTo(randomInput);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 범위_벗어난_사용자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복된_사용자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("455"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_아닌_사용자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 난수_생성후_개수_테스트() {
        RandomUtil randomUtil = new RandomUtil();
        assertThat(randomUtil.createRandomList().size()).isEqualTo(3);
    }

    @Test
    void 난수_생성후_범위_테스트() {
        RandomUtil randomUtil = new RandomUtil();
        randomUtil.createRandomList().forEach(number ->
                assertThat(number).isBetween(1, 9)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
