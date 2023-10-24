package baseball.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PatternHelperTest {
        @Test
        void call_getDistinctDigitNumberPattern_given_limit() {
                //given
                int limit = 3;

                //when
                String pattern = PatternHelper.getDistinctDigitNumberPattern(limit);

                //then
                Assertions.assertThat(pattern).isEqualTo("^(?!.*(.).*\\1)[1-9]{3}$");
        }
}
