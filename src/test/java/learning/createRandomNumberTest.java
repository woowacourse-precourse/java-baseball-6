package learning;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class createRandomNumberTest {

    @Test
    void 랜덤으로_숫자_세_개_생성() {
        // given
        List<Integer> computer = new ArrayList<>();
        // when
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        // then
        Assertions.assertTrue(isThreeDifferentNumbers(computer));
    }

    boolean isThreeDifferentNumbers(List<Integer> numbers) {
        int[] countOf = new int[10];
        for (Integer n : numbers) {
            countOf[n] += 1;
            if (countOf[n] > 1) {
                return false;
            }
        }
        return true;
    }
}
