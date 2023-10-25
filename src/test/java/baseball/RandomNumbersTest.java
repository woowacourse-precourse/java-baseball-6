package baseball;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumbersTest {
    @DisplayName("랜덤 사용법 테스트, 한자리 숫자를 뽑아본다.")
    @Test
    void randomNumberTest() {
        List<Integer> numberList = new ArrayList<>(Arrays.asList(1));
        int randomNumber = Randoms.pickNumberInList(numberList);
        assertThat(randomNumber).isEqualTo(1);
    }

    @DisplayName("랜덤 사용법 테스트, 세자리 숫자를 뽑아본다.")
    @Test
    void randomNumbersTest() {
        List<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 3, 3);
        assertThat(randomNumbers.size()).isEqualTo(3);
    }
}