package baseball.core;


import baseball.exception.IllegalCountException;
import baseball.exception.IllegalTypeException;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberPickerTest {

    @Test
    void picRandomNumberTest() {
        //if
        NumberPicker numberPicker = new NumberPicker();

        //when
        List<Integer> integers = numberPicker.pickRandomNumber();

        //then
        Assertions.assertThat(integers).size().isEqualTo(3);
        for (Integer integer : integers) {
            Assertions.assertThat(integer).isBetween(0, 9);
        }
    }

    @Test
    void picConsoleNumberTest() {
        //if
        NumberPicker numberPicker = new NumberPicker();

        //when
        List<Integer> results = numberPicker.picConsoleNumber("219");

        //then
        Assertions.assertThat(results).contains(2,1,9);
        Assertions.assertThat(results).size().isEqualTo(3);

        Assertions.assertThatThrownBy(() -> numberPicker.picConsoleNumber("1294"))
                .isInstanceOf(IllegalCountException.class);

        Assertions.assertThatThrownBy(() -> numberPicker.picConsoleNumber("ssss"))
                .isInstanceOf(IllegalTypeException.class);
    }

    @Test
    void st() {
        int i = Randoms.pickNumberInRange(0, 9);
        System.out.println("i = " + i);
    }
}