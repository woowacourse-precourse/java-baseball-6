package baseball.domain.compararesult;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[CompareResultTest]")
class CompareResultTest {

    @Test
    @DisplayName("생성자로 생성시 strike, ball이 0으로 초기회됨")
    void initZeroWhenConstructed() {
        // given, when
        CompareResult compareResult = new CompareResult();

        // then
        assertThat(compareResult.toString()).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("addStrike 메소드를 통해 strike에 1을 더할 수 있다.")
    void addOneStrikeWhenAddStrike() {
        // given
        CompareResult compareResult = new CompareResult();

        // when
        compareResult.addStrike();
        compareResult.addStrike();

        // then
        assertThat(compareResult.toString()).isEqualTo("2스트라이크");
    }

    @Test
    @DisplayName("addBall 메소드를 통해 ball에 1을 더할 수 있다.")
    void addOneBallWhenAddBall() {
        // given
        CompareResult compareResult = new CompareResult();

        // when
        compareResult.addBall();

        // then
        assertThat(compareResult.toString()).isEqualTo("1볼");
    }

    @Test
    @DisplayName("정답을 맞춘 경우(strike가 3) isAnswer 메소드가 true를 반환한다.")
    void isAnswerReturnTrueWhenStrikeIsThree() {
        // given
        CompareResult compareResult = new CompareResult();
        compareResult.addStrike();
        compareResult.addStrike();
        compareResult.addStrike();

        // when
        boolean result = compareResult.isAnswer();

        // then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("정답이 아닌 경우 isAnswer 메소드가 false를 반환한다.")
    void isAnswerReturnFalseWhenStrikeIsNotThree() {
        // given
        CompareResult compareResult = new CompareResult();
        compareResult.addStrike();
        compareResult.addStrike();

        // when
        boolean result = compareResult.isAnswer();

        // then
        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("strike. ball 이 모두 0인 경우 toString이 '낫싱'을 반환한다.")
    void toStringReturnNothingWhenStrikeAndBallAllZero() {
        // given
        CompareResult compareResult = new CompareResult();
        String expectedMessage = "낫싱";

        // when
        String message = compareResult.toString();

        // then
        assertThat(message).isEqualTo(expectedMessage);
    }

    @Test
    @DisplayName("strike. ball 이 모두 0이 아닌 경우 toString이 적절한 문자열 반환한다.")
    void toStringReturnRightMessageWhenStrikeAndBallNotZero() {
        // given
        CompareResult compareResult = new CompareResult();
        compareResult.addStrike();
        compareResult.addBall();
        compareResult.addBall();
        String expectedMessage = "2볼 1스트라이크";

        // when
        String message = compareResult.toString();

        // then
        assertThat(message).isEqualTo(expectedMessage);
    }

    @Test
    @DisplayName("ball만 있을 경우 뒤에 공백이 없다.")
    void noSpaceAfterBallWhenOnlyBallHasCount() {
        // given
        CompareResult compareResult = new CompareResult();
        compareResult.addBall();
        String expectedMessage = "1볼";
        String wrongExpectedMessage = "1볼 ";

        // when
        String message = compareResult.toString();

        // then
        assertThat(message).isEqualTo(expectedMessage);
        assertThat(message).isNotEqualTo(wrongExpectedMessage);
    }
}