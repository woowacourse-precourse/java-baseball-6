package baseball.domain.gamedata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.domain.dto.GameResult;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballNumberTest {
    
    @DisplayName("String 인자로 받아 객체 생성하는 of에 대한 예외 테스트")
    @Test
    public void whenCallOfWithInvalidInput_thenFail() throws  Exception {
        //given
        String invalidContentTypeInput = "1a3";
        String invalidSizeInput = "1234";
        String invalidDuplicationInput = "112";
        //when then
        assertThrows(IllegalArgumentException.class, () -> BaseballNumber.of(invalidContentTypeInput));
        assertThrows(IllegalArgumentException.class, () -> BaseballNumber.of(invalidSizeInput));
        assertThrows(IllegalArgumentException.class, () -> BaseballNumber.of(invalidDuplicationInput));
    }

    @DisplayName("String 인자로 받아 객체 생성하는 of에 대한 테스트: 생성 성공")
    @Test
    public void whenCallOfWithValidInput_thenSuccess() throws  Exception {
        //given
        String input = "123";
        int expectedSize = 3;
        //when
        BaseballNumber baseballNumber = BaseballNumber.of(input);
        String baseballNumberConvertedString = baseballNumber.numbers()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
        int baseballNUmberSize = baseballNumber.numbers().size();
        // then
        assertThat(baseballNUmberSize).isEqualTo(expectedSize);
        assertThat(baseballNumberConvertedString).isEqualTo(input);
    }

    @DisplayName("게임 결과 산출 성공")
    @Test
    public void whenMakeGameResultWithTwoBaseballNumber_thenSuccess() throws  Exception {
        //given
        BaseballNumber gameSuccessTarget = new BaseballNumber(List.of(1, 2, 3));
        BaseballNumber gameSuccessAnswer = new BaseballNumber(List.of(1, 2, 3));
        int successStrike = 3; int successBall = 0;

        BaseballNumber strikeAndBallTarget = new BaseballNumber(List.of(1, 2, 3));
        BaseballNumber strikeAndBallAnswer = new BaseballNumber(List.of(3, 2, 1));
        int expectedStrike = 1; int expectedBall = 2;

        BaseballNumber nothingTarget = new BaseballNumber(List.of(1, 2, 3));
        BaseballNumber nothingAnswer = new BaseballNumber(List.of(4, 5, 6));
        int nothingStrike = 0; int nothingBall = 0;
        //when
        GameResult successResult = gameSuccessTarget.calculateResult(gameSuccessAnswer);
        GameResult strikeAndBallResult = strikeAndBallTarget.calculateResult(strikeAndBallAnswer);
        GameResult nothingResult = nothingTarget.calculateResult(nothingAnswer);

        //then
        assertThat(successResult.isCompleted()).isTrue();
        assertThat(successResult.isNothing()).isFalse();
        assertThat(successResult.strike()).isEqualTo(successStrike);
        assertThat(successResult.ball()).isEqualTo(successBall);

        assertThat(strikeAndBallResult.isCompleted()).isFalse();
        assertThat(strikeAndBallResult.isNothing()).isFalse();
        assertThat(strikeAndBallResult.strike()).isEqualTo(expectedStrike);
        assertThat(strikeAndBallResult.ball()).isEqualTo(expectedBall);

        assertThat(nothingResult.isCompleted()).isFalse();
        assertThat(nothingResult.isNothing()).isTrue();
        assertThat(nothingResult.strike()).isEqualTo(nothingStrike);
        assertThat(nothingResult.ball()).isEqualTo(nothingBall);
    }

}