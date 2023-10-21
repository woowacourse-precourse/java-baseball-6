package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.model.RandomNumberCreator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 랜덤숫자생성_테스트() {
        RandomNumberCreator randomNumber = new RandomNumberCreator();
        randomNumber.setRandomNumber();
        int[] generatedNumbers = randomNumber.getAnswer(); // 정답을 테스트코드에 들고 오는 게 맞을까?

        // 세 자릿수 테스트
        assertThat(randomNumber.getAnswer().length).isEqualTo(3);

        // 숫자 범위 테스트
        for (int number : generatedNumbers) {
            assertThat(number).isBetween(1, 9);
        }

        // 숫자 중복 여부 테스트
        assertThat(generatedNumbers[0]).isNotEqualTo(generatedNumbers[1]);
        assertThat(generatedNumbers[0]).isNotEqualTo(generatedNumbers[2]);
        assertThat(generatedNumbers[1]).isNotEqualTo(generatedNumbers[2]);
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
