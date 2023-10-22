package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PitchResultTest {
    @DisplayName("볼, 스트라이크 결과 메시지를 정확하게 리턴하는지 확인합니다.")
    @ParameterizedTest
    @CsvSource(value = {
            "3/0/3스트라이크",
            "2/0/2스트라이크",
            "1/0/1스트라이크",
            "0/2/2볼",
            "0/1/1볼",
            "1/2/2볼 1스트라이크",
            "1/1/1볼 1스트라이크",
            "0/0/낫싱"
    }, delimiter = '/')
    void getHint_ReturnCorrectMessage(int strikeCount, int ballCount, String expectedMessage) {
        PitchResult pitchResult = new PitchResult(strikeCount, ballCount);

        assertThat(pitchResult.getHint()).isEqualTo(expectedMessage);
    }
}