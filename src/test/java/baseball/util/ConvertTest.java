package baseball.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ConvertTest {

    @Test
    @DisplayName("")
    void testConvertStringToIntegerList() {
        String input = "123";

        List<Integer> userNumber = Convert.convertStringToIntegerList(input);

        assertThat(userNumber.size()).isEqualTo(3);
        assertThat(userNumber.get(0)).isEqualTo(1);
        assertThat(userNumber.get(1)).isEqualTo(2);
        assertThat(userNumber.get(2)).isEqualTo(3);
    }
}
