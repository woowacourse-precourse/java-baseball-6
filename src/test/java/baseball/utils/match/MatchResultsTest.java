package baseball.utils.match;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MatchResultsTest {

    @ParameterizedTest
    @MethodSource("getMatchResults")
    void isAllStrike(MatchResults matchResults, boolean expected) {
        // then
        assertThat(matchResults.isAllStrike()).isEqualTo(expected);
    }

    public static Stream<Arguments> getMatchResults() {
        MatchResults matchResults = new MatchResults();
        matchResults.match(MatchResult.STRIKE);
        matchResults.match(MatchResult.STRIKE);
        matchResults.match(MatchResult.STRIKE);

        return Stream.of(
                Arguments.of(new MatchResults(), false),
                Arguments.of(matchResults, true)
        );
    }
}
