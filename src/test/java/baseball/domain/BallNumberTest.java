package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class BallNumberTest {
    @DisplayName("입력된 3자리 정수가 각각의 자릿수에 해당하는 인덱스에 저장되는지 확인")
    @Test
    void isCorrectlySaved() {
        BallNumber ballNumber = new BallNumber("426");
        ArrayList<Integer> expacted = new ArrayList<>();
        expacted.add(4);
        expacted.add(2);
        expacted.add(6);
        assertTrue(ballNumber.ballNumber.equals(expacted));
    }
}
