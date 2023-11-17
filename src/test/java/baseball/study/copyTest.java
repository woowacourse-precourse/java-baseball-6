package baseball.study;

import baseball.model.UserNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class copyTest {
    @DisplayName("방어적 복사")
    @Test
    void copy() {
        String inputStr = "123";
//        List<Integer> numbersArr = Arrays.asList(1, 2, 3);
        UserNumber userNumber = UserNumber.from(inputStr);
        userNumber.getNumbers().add(6);
        System.out.println("userNumber.getNumbers() = " + userNumber.getNumbers());

    }
}
