package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConvertInputToArrTest {

    @DisplayName("입력된 문자열은 int형 배열로 변환된다.")
    @Test
    void 입력된_문자열은_int형_배열로_변환된다() {
        //given
        String str = "123";
        int[] intArr = new int[]{1, 2, 3};

        //then
        assertThat(ConvertInputToArr.inputToArr(str)).isEqualTo(intArr);
    }


}