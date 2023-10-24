package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void init() {
        User user = new User();
        List<Integer> inputList;

        //정상 입력
        String input = "123";
        inputList = user.init(input);
        assertThat(inputList).isEqualTo(Arrays.asList(1,2,3));

        //3자 이상 입력
        String inputLong = "1234";
        assertThrows(IllegalArgumentException.class, () -> user.init(inputLong));

        //중복 입력
        String inputDuplicate = "122";
        assertThrows(IllegalArgumentException.class, () -> user.init(inputDuplicate));

        //0 입력
        String inputZero = "012";
        assertThrows(IllegalArgumentException.class, () -> user.init(inputZero));

        //문자 입력
        String inputChar = "1z2";
        assertThrows(IllegalArgumentException.class, () -> user.init(inputChar));

    }
}
