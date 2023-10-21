package baseball.results;

import baseball.utils.ResultsUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ResultsUtilToStringTest {

    @Test
    void n_스트라이크_반환() {
        // given
        ResultStatus resultStatus = ResultStatus.STRIKE;
        int count = 1;

        // when
        String string = ResultsUtils.getStringValueOfResultStatusWithCount(resultStatus, count);
        String expectedString = "1스트라이크";

        // then
        Assertions.assertEquals(string, expectedString);
    }

    @Test
    void n_볼_반환() {
        // given
        ResultStatus resultStatus = ResultStatus.BALL;
        int count = 2;

        // when
        String string = ResultsUtils.getStringValueOfResultStatusWithCount(resultStatus, count);
        String expectedString = "2볼";

        // then
        Assertions.assertEquals(string, expectedString);
    }

    @Test
    void 해당_판정_없음() {
        // given
        ResultStatus resultStatus = ResultStatus.OUT;
        int count = 0;

        // when
        String string = ResultsUtils.getStringValueOfResultStatusWithCount(resultStatus, count);
        String expectedString = "";

        // then
        Assertions.assertEquals(string, expectedString);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3,0,3스트라이크",
            "2,1,1볼 2스트라이크",
            "2,0,2스트라이크",
            "1,2,2볼 1스트라이크",
            "1,1,1볼 1스트라이크",
            "1,0,1스트라이크",
            "0,3,3볼",
            "0,2,2볼",
            "0,1,1볼",
            "0,0,낫싱",
    })
    void 판별_출력값_반환(int strikeCount, int ballCount, String expected) {
        // when
        String result = ResultsUtils.getStringValueOfResults(strikeCount, ballCount);

        // then
        Assertions.assertEquals(result, expected);
    }

}
