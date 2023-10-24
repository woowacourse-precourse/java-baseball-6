package utils;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilsTest {
    Utils utils = new Utils();

    @Test
    public void 문자열을_정수형_리스트로_변환_테스트() {
        //given
        String input = "967";
        int[] input_array = new int[]{9, 6, 7};
        //when
        List<Integer> intList = utils.stringToIntList(input);
        //then
        for (int i = 0; i < intList.size(); i++) {
            System.out.println(intList.get(i));
            Assertions.assertEquals(intList.get(i), input_array[i]);
        }
    }

    @Test
    public void 정수형_리스트를_문자열로_변환_테스트() {
        //given
        List<Integer> intList = Arrays.asList(1, 2, 3);
        //when
        String string = utils.intListToString(intList);
        //then
        Assertions.assertEquals("123", string);
    }

    @Test
    public void 사용자입력이_공백인_경우() {
        String input = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> utils.inputLengthIsZero(input));
    }

    @Test
    public void 사용자입력이_3보다_작은경우() {
        String input = "12";
        Assertions.assertThrows(IllegalArgumentException.class, () -> utils.inputLengthIsUnder(input));
    }

    @Test
    public void 사용자입력이_3보다_큰_경우() {
        String input = "1234";
        Assertions.assertThrows(IllegalArgumentException.class, () -> utils.inputLengthIsOver(input));
    }

    @Test
    public void 사용자입력이_숫자가_아닌경우() {
        String input = "asdf";
        Assertions.assertThrows(IllegalArgumentException.class, () -> utils.inputIsNotNumber(input));
    }

    @Test
    public void 사용자입력이_중복된_경우() {
        String input = "113";
        Assertions.assertThrows(IllegalArgumentException.class, () -> utils.duplicateNumber(input));
    }
}
