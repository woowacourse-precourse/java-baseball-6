package baseball;

import baseball.Domain.Baseball;
import baseball.Domain.BaseballScore;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BaseballTest {

    @Test
    @DisplayName("Baseball 객체가 잘 만들어지는지 확인")
    void BaseballBuildTest() {
        List<Integer> numbers = List.of(1, 2, 3);
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> new Baseball(numbers));
    }

    @Test
    @DisplayName("잘못된 숫자 개수 입력")
    void 숫자_4개_넣기() {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> new Baseball(numbers)
        );
    }

    @Test
    @DisplayName("0 포함 숫자 입력")
    void 숫자_0_넣기() {
        List<Integer> numbers = List.of(0, 1, 2);
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> new Baseball(numbers)
        );
    }

    @Test
    @DisplayName("점수 잘 산정하는지 확인")
    void 점수_테스트() {
        Baseball b1 = new Baseball(List.of(1, 2, 3)), b2 = new Baseball(List.of(3, 2, 1));

        BaseballScore score = b1.compare(b2), expect = new BaseballScore(2, 1);

        Assertions.assertThat(score.toString()).isEqualTo(expect.toString());
    }

    @Test
    @DisplayName("낫싱 출력 확인")
    void 낫싱_테스트() {
        Baseball b1 = new Baseball(List.of(1, 2, 3)), b2 = new Baseball(List.of(4, 5, 6));

        BaseballScore score = b1.compare(b2), expect = new BaseballScore(0, 0);

        Assertions.assertThat(score.toString()).isEqualTo(expect.toString());
    }

}

