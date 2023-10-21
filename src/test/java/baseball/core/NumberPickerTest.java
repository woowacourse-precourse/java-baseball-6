package baseball.core;


import baseball.exception.IllegalCountException;
import baseball.exception.IllegalRangeException;
import baseball.exception.IllegalTypeException;
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
        List<Integer> results = numberPicker.pickNumberByInput("2 1 9");

        //then
        Assertions.assertThat(results).contains(2,1,9);
        Assertions.assertThat(results).size().isEqualTo(3);

        Assertions.assertThatThrownBy(() -> numberPicker.pickNumberByInput("1 2 11"))
                .isInstanceOf(IllegalRangeException.class);

        Assertions.assertThatThrownBy(() -> numberPicker.pickNumberByInput("1 2 9 4"))
                .isInstanceOf(IllegalCountException.class);

        Assertions.assertThatThrownBy(() -> numberPicker.pickNumberByInput("1 2 9 ㄴ"))
            .isInstanceOf(IllegalTypeException.class);
    }
}