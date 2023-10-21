package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MessageTest {

    @DisplayName("게임 시작의 메세지 테스트")
    @Test
    void startTest() {
        //given
        Message message = new Message();
        //when
        final String startMessage = message.start();
        //then
        assertThat(startMessage).isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    @DisplayName("유저에게 숫자입력을 요청하는 메시지 테스트")
    @Test
    void requestInputTest() {
        //given
        Message message = new Message();
        //when
        final String requestInputMessage = message.requestInput();
        //then
        assertThat(requestInputMessage).isEqualTo("숫자를 입력해주세요 : ");
    }

    @Test
    void successTest() {
        //given
        Message message = new Message();
        //when
        final String successMessage = message.success();
        //then
        assertThat(successMessage).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @DisplayName("유저에게 게임 재시작, 종료를 요청하는 메시지 테스트")
    @Test
    void requestRetryOrEndTest() {
        //given
        Message message = new Message();
        //when
        final String requestRetryOrEndMessage = message.requestRetryOrEnd();
        //then
        assertThat(requestRetryOrEndMessage).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @DisplayName("게임 결과 볼과 스트라이크가 존재하지 않을 경우의 테스트")
    @Test
    void nothingResultTest() {
        //given
        Message message = new Message();
        //when
        final String nothingResult = message.result(null);
        //then
        assertThat(nothingResult).isEqualTo("낫싱");
    }

    @DisplayName("게임 결과 오직 볼만 존재할 경우의 테스트")
    @Test
    void onlyBallResultTest() {
        //given
        Message message = new Message();
        //when
        final int ball = 2;
        final int strike = 0;
        final String onlyBallResult = message.result(List.of(ball, strike));
        //then
        assertThat(onlyBallResult).isEqualTo(ball + "볼");
    }

    @DisplayName("게임 결과 오직 스트라이크만 존재할 경우의 테스트")
    @Test
    void onlyStrikeResultTest() {
        //given
        Message message = new Message();
        //when
        final int ball = 0;
        final int strike = 3;
        final String onlyStrikeResult = message.result(List.of(ball, strike));
        //then
        assertThat(onlyStrikeResult).isEqualTo(strike + "스트라이크");
    }

    @DisplayName("게임 결과 볼과 스트라이크 모두 존재할 경우의 테스트")
    @Test
    void ballAndStrikeResultTest() {
        //given
        Message message = new Message();
        //when
        final int ball = 1;
        final int strike = 2;
        final String ballAndStrikeResult = message.result(List.of(ball, strike));
        //then
        assertThat(ballAndStrikeResult).isEqualTo(ball + "볼 " + strike + "스트라이크");
    }
}