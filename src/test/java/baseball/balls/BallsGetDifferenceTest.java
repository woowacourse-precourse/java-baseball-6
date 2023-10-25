package baseball.balls;

import baseball.domain.balls.Balls;
import baseball.dto.BallsDifferenceDto;
import baseball.utility.ConvertorUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallsGetDifferenceTest {

    @ParameterizedTest
    @CsvSource(value = {
            "123,123,3,0,0",
            "123,124,2,0,1",
            "123,142,1,1,1",
    })
    void BallsDifferenceDto_생성_확인(
            String ballsString1,
            String ballsString2,
            int expectedSameBallCount,
            int expectedSameValueBallCount,
            int expectedDifferentBallCount
    ) {
        // given
        Balls balls1 = ConvertorUtils.convertStringToBalls(ballsString1);
        Balls balls2 = ConvertorUtils.convertStringToBalls(ballsString2);

        // when
        BallsDifferenceDto ballsDifferenceDto = balls1.getDifference(balls2);
        int sameBallCount = ballsDifferenceDto.getSameBallCount();
        int sameValueBallCount = ballsDifferenceDto.getSameValueBallCount();
        int differentBallCount = ballsDifferenceDto.getDifferentBallCount();

        // then
        Assertions.assertEquals(sameBallCount, expectedSameBallCount);
        Assertions.assertEquals(sameValueBallCount, expectedSameValueBallCount);
        Assertions.assertEquals(differentBallCount, expectedDifferentBallCount);
    }

}
