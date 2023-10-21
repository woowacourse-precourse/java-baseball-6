package baseball;

import baseball.Domain.Baseball;
import baseball.Domain.BaseballScore;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballTest {

    @Test
    @DisplayName("Baseball 객체가 잘 만들어지는지 확인")
    void BaseballBuildTest() {
        String numbers = "123";
        Baseball baseball = new Baseball(numbers);
    }

    @Test
    @DisplayName("잘못된 숫자 개수 입력")
    void 숫자_4개_넣기() {
        String numbers = "1234";
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> new Baseball(numbers)
        );
    }

    @Test
    @DisplayName("0 포함 숫자 입력")
    void 숫자_0_넣기() {
        String numbers = "012";
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> new Baseball(numbers)
        );
    }

    @Test
    @DisplayName("숫자가 아닌 문자 입력")
    void 알파벳_넣기() {
        String numbers = "abc";
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> new Baseball(numbers)
        );
    }

    @Test
    @DisplayName("점수 잘 산정하는지 확인")
    void 점수_테스트() {
        String n1 = "123", n2 = "321";
        Baseball b1 = new Baseball(n1), b2 = new Baseball(n2);

        BaseballScore score = b1.compare(b2), expect = new BaseballScore(2, 1);

        Assertions.assertThat(score.toString()).isEqualTo(expect.toString());

    }

}

