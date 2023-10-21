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

}
