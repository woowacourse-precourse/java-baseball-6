package baseball.util;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.model.player.GuessNumber;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringToGuessNumberListConverterTest {

    @Test
    @DisplayName("문자열을 List<GuessNumber> 형태로 변환한다.")
    void StringToGuessNumberList_Test() {
        // given
        String input = "12345";
        List<GuessNumber> expectedList = List.of(new GuessNumber(1), new GuessNumber(2), new GuessNumber(3),
                new GuessNumber(4), new GuessNumber(5));

        // when
        List<GuessNumber> resultList = StringToGuessNumberListConverter.StringToGuessNumberList(input);

        // then
        assertAll(() -> IntStream.range(0, expectedList.size())
                .forEach(i -> assertEquals(expectedList.get(i).getNumber(),
                        resultList.get(i).getNumber()))
        );
    }
}