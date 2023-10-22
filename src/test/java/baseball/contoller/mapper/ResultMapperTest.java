package baseball.contoller.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.controller.mapper.ResultMapper;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class ResultMapperTest {

    @CsvSource({"1, 1, 1볼 1스트라이크", "2, 1, 2볼 1스트라이크", "0, 0, 낫싱"})
    @ParameterizedTest
    void 스트라이크와_볼으로_문자열_결과를_만든다(int ballCont, int strikeCount, String expected) {

        // when
        String result = ResultMapper.mapToStringWith(ballCont, strikeCount);

        // then
        assertThat(result).isEqualTo(expected);
    }
}

