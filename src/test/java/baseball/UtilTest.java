package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class UtilTest {

    @Test
    @DisplayName("임의의 값은 length 자리수이다.")
    void getRandomNumberTest1() {

        //given
        int length = 3;

        //when
        List<Integer> randomNumber = Util.getRandomNumber(length);

        //then
        Assertions.assertEquals(length, randomNumber.size());
    }

    @Test
    @DisplayName("임의의 값의 각 자리의 수는 중복되지 않는다.")
    void getRandomNumberTest2() {

        //given
        int length = 3;
        List<Integer> randomNumber = Util.getRandomNumber(length);

        //when
        boolean isDuplicated = false;
        for(int i = 0; i < randomNumber.size(); i++) {
            for(int j = i + 1; j < randomNumber.size(); j++) {
                if(randomNumber.get(i) == randomNumber.get(j)) {
                    isDuplicated = true;
                }
            }
        }

        //then
        Assertions.assertFalse(isDuplicated);
    }

    @Test
    @DisplayName("1~9 사이의 숫자가 아닌 입력값이 포함되면 예외가 발생한다. : 0포함")
    void validateStringOnlyNumbersTest1() {

        //given, when
        String inputString = "906";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> Util.validateStringOnlyNumbers(inputString));
    }

    @Test
    @DisplayName("1~9 사이의 숫자가 아닌 입력값이 포함되면 예외가 발생한다. : 문자 포함")
    void validateStringOnlyNumbersTest2() {

        //given, when
        String inputString = "9s6";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> Util.validateStringOnlyNumbers(inputString));
    }

    @Test
    @DisplayName("length 자리수가 아니면 예외가 발생한다.")
    void validateStringLengthTest() {

        //given, when
        int length = 3;
        String inputString = "96";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> Util.validateStringLength(inputString, length));
    }

    @Test
    @DisplayName("중복된 값이 포함된 경우 예외가 발생한다.")
    void validateStringDuplicateTest() {

        //given, when
        String inputString = "393";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> Util.validateStringDuplicate(inputString));
    }

    @Test
    @DisplayName("문자열(String형)을 List<Integer>형으로 변환한다.")
    void stringToIntegerListTest() {

        //given
        String inputString = "289";

        //when
        List<Integer> integerList = Util.stringToIntegerList(inputString);

        //then
        Assertions.assertEquals(2, integerList.get(0));
        Assertions.assertEquals(8, integerList.get(1));
        Assertions.assertEquals(9, integerList.get(2));
        Assertions.assertEquals(3, integerList.size());
    }

    @Test
    void validateExitCodeTest() {

        //given, when
        String input = "0";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> Util.validateExitCode(input));
    }
}