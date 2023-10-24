package baseball.api.request;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class SupportedRetryRequestTest {

    @DisplayName("사용자의 재시도 요청은 1,2 숫자만 요청할 수 있다.")
    @TestFactory
    Collection<DynamicTest> isRetry() {
        // given
        return List.of(
                DynamicTest.dynamicTest("사용자 입력으로 1이 들어오는 경우", () -> {
                    //given
                    String userRequest = "1";
                    //when
                    SupportedRetryRequest retryRequest = SupportedRetryRequest.isRetry(userRequest);
                    //then
                    assertThat(retryRequest.isFlag()).isTrue();

                }),
                DynamicTest.dynamicTest("사용자 입력으로 2가 들어오는 경우", () -> {
                    //given
                    String userRequest = "2";
                    //when
                    SupportedRetryRequest retryRequest = SupportedRetryRequest.isRetry(userRequest);
                    //then
                    assertThat(retryRequest.isFlag()).isFalse();
                })
        );
    }

    @DisplayName("사용자의 재시도 요청을 검증할 수 있다.")
    @ParameterizedTest(name ="{0}를 입력시 예외가 발생한다.")
    @ValueSource(strings = {"3","baseball","12","우테코","0"})
    public void isRetryException(String request) {
        // when // then
        Assertions.assertThatThrownBy(() -> SupportedRetryRequest.isRetry(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("다시 시도하려면 1 종료하려면 2를 입력하세요");
    }
}