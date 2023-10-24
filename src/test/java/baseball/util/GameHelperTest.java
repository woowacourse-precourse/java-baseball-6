package baseball.util;

import static java.lang.Character.getNumericValue;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameHelperTest {

    @Test
    @DisplayName("String 형의 숫자 값을 숫자 리스트로 변환한다.")
    public void String_형의_숫자_값을_숫자_리스트로_변환한다() {
        //given
        String numberValue = "123";

        //when
        List<Integer> integers = GameHelper.changeNumberToIntegerList(numberValue);

        //then
        for (int i = 0; i < integers.size(); i++) {
            int value = getNumericValue(numberValue.charAt(i));
            Integer integer = integers.get(i);
            assertThat(value).isEqualTo(integer);
        }
    }
}
