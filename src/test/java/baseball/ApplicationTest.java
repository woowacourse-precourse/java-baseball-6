package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("임의의 숫자 3개를 생성한다")
    void 임의의_숫자_3개를_생성한다() {

        // Given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // When
        List<Integer> randomNumbers = randomNumberGenerator.createNumbers();

        // Then
        assertThat(randomNumbers).hasSize(3);
    }

    @Test
    @DisplayName("사용자가 입력한 숫자가 3자리가 아니면 예외를 반환한다")
    void 사용자가_입력한_숫자가_3자리인지_체크한다() {

        // Given
        String testNumber = "1234";
        UserNumberValidator userNumberValidator = new UserNumberValidator();

        // When & Then
        Assertions.assertThatThrownBy(() -> userNumberValidator.validateThreeDigitNumber(testNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("세자리 숫자가 아닙니다");
    }

    @Test
    @DisplayName("사용자가 입력한 숫자의 각 자리가 중복된다면 예외를 반환한다")
    void 사용자가_입력한_숫자가_중복되는지_체크한다() {

        // Given
        String testNumber = "112";
        UserNumberValidator userNumberValidator = new UserNumberValidator();

        // When & Then
        Assertions.assertThatThrownBy(() -> userNumberValidator.validateDuplicatedNumber(testNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자를 입력했습니다");
    }

    @Test
    @DisplayName("컴퓨터가 생성한 숫자와 유저가 생성한 숫자 중 일치하는 수의 개수를 확인한다")
    void 컴퓨터가_생성한_숫자와_유저가_생성한_숫자중_일치하는_개수를_확인한다() {

        // Given
        GameCounter counter = new GameCounter();
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> userNumbers = List.of(3, 2, 1);

        // When
        int result = counter.countTotal(computerNumbers, userNumbers);

        // Then
        assertThat(result).isEqualTo(3);

    }

    @Test
    @DisplayName("컴퓨터가 생성한 숫자와 유저가 생성한 숫자 중 각 자리의 수까지 동일한 개수를 확인한다")
    void 컴퓨터가_생성한_숫자와_유저가_생성한_숫자중_각자리의_수까지_동일한_개수를_확인한다() {

        // Given
        GameCounter counter = new GameCounter();
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> userNumbers = List.of(4, 2, 3);

        // When
        int result = counter.countStrike(computerNumbers, userNumbers);

        // Then
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("같은 숫자를 포함하고 위치도 일치할 경우 스트라이크만 출력한다")
    void 같은_숫자를_포함하고_위치도_일치할_경우_스트라이크만_출력한다() {

        // Given
        Judgement judgement = new Judgement();
        int total = 2;
        int strike = 2;

        // When
        String result = judgement.judge(total, strike);

        // Then
        assertThat(result).contains("스트라이크");
        assertThat(result).doesNotContain("볼");
    }

    @Test
    @DisplayName("아무것도 맞추지 못한 경우 낫싱을 출력한다")
    void 아무것도_맞추지_못한_경우_낫싱을_출력한다() {

        // Given
        Judgement judgement = new Judgement();
        int total = 0;
        int strike = 0;

        // When
        String result = judgement.judge(total, strike);

        // Then
        assertThat(result).isEqualTo("낫싱");

    }

    @Test
    @DisplayName("같은 숫자를 포함하고 있지만 자리가 모두 다른 경우 볼만 출력한다")
    void 같은_숫자를_포함하고있지만_자리가_모두_다른_경우_볼만_출력한다() {

        // Given
        Judgement judgement = new Judgement();
        int total = 2;
        int strike = 0;

        // When
        String result = judgement.judge(total, strike);

        // Then
        assertThat(result).contains("볼");
        assertThat(result).doesNotContain("스트라이크");
    }

    @Test
    @DisplayName("스트라이크인 경우와 볼인 경우가 혼합되어 있는 경우 X볼 X스트라이크를 출력한다")
    void 스트라이크와_볼_모두_해당하는_경우_X볼_X스트라이크를_출력한다() {

        // Given
        Judgement judgement = new Judgement();
        int total = 3;
        int strike = 1;

        // When
        String result = judgement.judge(total, strike);

        // Then
        assertThat(result).contains("볼");
        assertThat(result).contains("스트라이크");
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
