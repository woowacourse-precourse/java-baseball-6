package baseball.view.output;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.dto.ComparisonResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ComparisonResultViewTest {

    @ParameterizedTest(name = "strike : {0}, ball : {1}, except : {2}")
    @CsvSource({"2,0,2스트라이크", "0,3,3볼", "1,2,2볼 1스트라이크", "0,0,낫싱"})
    @DisplayName("비교 결과를 출력 메세지로 바꿀 수 있다")
    void changeToOutputMessageTest(int strike, int ball, String expected) {
        ComparisonResult result = new ComparisonResult(strike, ball, false);

        String actual = new ComparisonResultView().changeToOutputMessage(result);

        assertThat(actual).isEqualTo(expected);
    }
}
