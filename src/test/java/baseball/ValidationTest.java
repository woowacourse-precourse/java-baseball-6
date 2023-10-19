package baseball;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidationTest {

    @Test
    public void 입력값_변환_체크(){
        Validation validation = new Validation();
        String input = "123";
        List<Integer> answer = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> inputList = validation.checkUserInput(input);

        assertThat(answer).isEqualTo(inputList);
    }

    @Test
    public void 입력값길이_예외_체크(){
        Validation validation = new Validation();
        String input = "1234";

        assertThatThrownBy(()-> validation.checkUserInput(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력값중복_예외_체크(){
        Validation validation = new Validation();
        String input = "122";

        assertThatThrownBy(()-> validation.checkUserInput(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력값범위_예외_체크(){
        Validation validation = new Validation();
        String input = "120";

        assertThatThrownBy(()-> validation.checkUserInput(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
