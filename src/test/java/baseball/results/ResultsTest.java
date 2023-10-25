package baseball.results;

import baseball.domain.results.Results;
import baseball.dto.BallsDifferenceDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ResultsTest {

    @ParameterizedTest
    @CsvSource(value = {
            "3,0,0,3스트라이크",
            "2,1,0,1볼 2스트라이크",
            "2,0,1,2스트라이크",
            "1,2,0,2볼 1스트라이크",
            "0,3,0,3볼",
            "0,2,1,2볼",
            "0,1,2,1볼",
            "0,0,3,낫싱",
    })
    void 판별_성공(int strikeCount, int ballCount, int outCount, String expectedString) {
        // given
        BallsDifferenceDto ballsDifferenceDto = new BallsDifferenceDto(strikeCount, ballCount, outCount);

        // when
        Results results = new Results(ballsDifferenceDto);
        String resultsString = results.toString();

        // then
        Assertions.assertEquals(resultsString, expectedString);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3,0,0,true",
            "2,1,0,false",
            "2,0,1,false",
            "1,2,0,false",
            "0,3,0,false",
            "0,2,1,false",
            "0,1,2,false",
            "0,0,3,false",
    })
    void 정답_판별(int strikeCount, int ballCount, int outCount, boolean expectedIsAnswer) {
        // given
        BallsDifferenceDto ballsDifferenceDto = new BallsDifferenceDto(strikeCount, ballCount, outCount);

        // when
        Results results = new Results(ballsDifferenceDto);
        boolean isAnswer = results.isAnswer();

        // then
        Assertions.assertEquals(isAnswer, expectedIsAnswer);
    }

}
