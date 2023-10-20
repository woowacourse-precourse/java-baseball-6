package baseball.Utils;

import baseball.Util.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParserTest {

    @Test
    @DisplayName("문자열을 숫자 ArrayList로 변환 테스트")
    public void convertStringToArrayListTest() {
        Parser parser = new Parser();
        String input = "123";
        List<Integer> convertedInput = Arrays.asList(1,2,3);

        assertThat(parser.convertStringToArrayList(input)).isEqualTo(convertedInput);
    }
}
