package baseball.game;

import baseball.Computer;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PredictGamePlayTest {

    // TODO 입력된 숫자에 알맞은 예측 결과를 출력합니다.

    @Test
    @DisplayName("입력된 숫자가 컴퓨터 숫자에 포함되나, 자리가 다르면 볼을 출력합니다")
    public void testPredictBall() throws Exception {
        // given
        Computer.number = "123";
        String test1 = "991";
        String test2 = "912";
        String test3 = "312";

        // when
        PredictGamePlay predictGamePlay = new PredictGamePlay();
        String result1 = predictGamePlay.play(List.of(test1));
        String result2 = predictGamePlay.play(List.of(test2));
        String result3 = predictGamePlay.play(List.of(test3));

        // then
        Assertions.assertThat(result1).isEqualTo("1볼");
        Assertions.assertThat(result2).isEqualTo("2볼");
        Assertions.assertThat(result3).isEqualTo("3볼");
    }

    @Test
    @DisplayName("입력된 숫자가 컴퓨터 숫자에 포함되고 자리가 같으면 스트라이크을 출력합니다")
    public void testPredictStrike() throws Exception {
        // given
        Computer.number = "123";
        String test1 = "199";
        String test2 = "129";
        String test3 = "123";

        // when
        PredictGamePlay predictGamePlay = new PredictGamePlay();
        String result1 = predictGamePlay.play(List.of(test1));
        String result2 = predictGamePlay.play(List.of(test2));
        String result3 = predictGamePlay.play(List.of(test3));

        // then
        Assertions.assertThat(result1).isEqualTo("1스트라이크");
        Assertions.assertThat(result2).isEqualTo("2스트라이크");
        Assertions.assertThat(result3).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("입력된 숫자가 컴퓨터 숫자에 아예 포함되지 않으면, 넛싱을 출력합니다.")
    public void testPredictNothing() throws Exception {
        // given
        Computer.number = "123";
        String test1 = "999";

        // when
        PredictGamePlay predictGamePlay = new PredictGamePlay();
        String result = predictGamePlay.play(List.of(test1));

        // then
        Assertions.assertThat(result).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("스트라이크와 볼이 섞인 경우, X볼 Y스트라이크 형식으로 반환합니다")
    public void testPredictBallStrike() throws Exception {
        // given
        Computer.number = "123";
        String test1 = "139";

        // when
        PredictGamePlay predictGamePlay = new PredictGamePlay();
        String result = predictGamePlay.play(List.of(test1));

        // then
        Assertions.assertThat(result).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("입력된 값이 세자리가 아닌 경우, 예외를 던집니다.")
    public void testExceptionInput4Digit() throws Exception {
        // given
        Computer.number = "123";
        String test1 = "9999";

        String msg = "잘못된 입력입니다, 예측 가능한 수는 세자리(1~9) 숫자입니다.";

        // when
        PredictGamePlay predictGamePlay = new PredictGamePlay();

        // then
        Assertions.assertThatThrownBy(() -> predictGamePlay.play(List.of(test1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(msg);
    }

    @Test
    @DisplayName("입력된 값이 세자리가 아닌 경우, 예외를 던집니다.")
    public void testExceptionInputZero() throws Exception {
        // given
        Computer.number = "123";
        String test1 = "120";

        String msg = "잘못된 입력입니다, 예측 가능한 수는 세자리(1~9) 숫자입니다.";

        // when
        PredictGamePlay predictGamePlay = new PredictGamePlay();

        // then
        Assertions.assertThatThrownBy(() -> predictGamePlay.play(List.of(test1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(msg);
    }

    @Test
    @DisplayName("입력된 값에 같은 숫자가 여러번 존재할 경우, 예외를 던집니다.")
    public void testExceptionInputDuplicated() throws Exception {
        // given
        Computer.number = "123";
        String test1 = "112";

        String msg = "잘못된 입력입니다, 예측 가능한 수는 세자리(1~9) 숫자입니다.";

        // when
        PredictGamePlay predictGamePlay = new PredictGamePlay();

        // then
        Assertions.assertThatThrownBy(() -> predictGamePlay.play(List.of(test1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(msg);
    }

}
