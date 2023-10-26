package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

    @Nested
    @DisplayName("사용자가 숫자를 입력했을때")
    class 사용자가_숫자를_입력했을때 {

        @Test
        @DisplayName("중간에 문자가 포함되어 있으면 예외를 반환한다")
        void 중간에_문자가_포함되어_있으면_예외를_반환한다() {

            // Given
            String testNumber = "12a";
            UserNumberValidator userNumberValidator = new UserNumberValidator();

            // When & Then
            Assertions.assertThatThrownBy(() -> userNumberValidator.validateNumericValue(testNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("숫자가 아닌 문자는 들어올 수 없습니다");
        }

        @Test
        @DisplayName("1부터 9범위 밖의 숫자가 들어오면 예외를 반환한다")
        void _1부터_9범위_밖의_숫자가_들어오면_예외를_반환한다() {

            // Given
            String testNumber = "120";
            UserNumberValidator userNumberValidator = new UserNumberValidator();

            // When & Then
            Assertions.assertThatThrownBy(() -> userNumberValidator.validateNumberRange(testNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("1부터 9까지의 숫자만 입력할 수 있습니다");
        }

        @Test
        @DisplayName("3자리가 아니면 예외를 반환한다")
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
        @DisplayName("각 자리가 중복된다면 예외를 반환한다")
        void 사용자가_입력한_숫자가_중복되는지_체크한다() {

            // Given
            String testNumber = "112";
            UserNumberValidator userNumberValidator = new UserNumberValidator();

            // When & Then
            Assertions.assertThatThrownBy(() -> userNumberValidator.validateDuplicatedNumber(testNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("중복된 숫자를 입력했습니다");
        }
    }

    @DisplayName("컴퓨터가 생성한 숫자와 유저가 생성한 숫자가 주어졌을때")
    @Nested
    class 컴퓨터_숫자와_유저_숫자가_주어졌을때 {

        @Test
        @DisplayName("양쪽 모두 포함된 숫자의 개수를 확인한다")
        void 양쪽_모두_포함된_숫자의_전체_개수를_확인한다() {

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
        @DisplayName("스트라이크인 숫자의 개수를 구한다")
        void 스트라이크인_숫자의_개수를_구한다() {

            // Given
            GameCounter counter = new GameCounter();
            List<Integer> computerNumbers = List.of(1, 2, 3);
            List<Integer> userNumbers = List.of(3, 2, 1);

            // When
            int result = counter.countStrike(computerNumbers, userNumbers);

            // Then
            assertThat(result).isEqualTo(1);

        }
    }


    @DisplayName("경기 결과를 분석할때")
    @Nested
    class 경기_결과를_분석할때 {

        @Test
        @DisplayName("스트라이크인 숫자만 있다면 스트라이크만 출력한다")
        void 스트라이크인_숫자만_있다면_스트라이크만_출력한다() {

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
        @DisplayName("볼인 숫자만 있다면 볼만 출력한다")
        void 볼인_숫자만_있다면_볼만_출력한다() {

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
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
