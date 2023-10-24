package baseball.model;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerModelTest {
    private static ComputerModel computerModel;
    private final List<Integer> expectedList = Arrays.asList(1, 2, 3);

    @BeforeAll
    static void setUp() {
        computerModel = new ComputerModel(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("인덱스 맞는 숫자 반환")
    void is_numberBy_Index() {
        Assertions.assertEquals(expectedList.get(0),
                computerModel.getSplitDigitFromRandomNumber(0));

        Assertions.assertEquals(expectedList.get(1),
                computerModel.getSplitDigitFromRandomNumber(1));

        Assertions.assertEquals(expectedList.get(2),
                computerModel.getSplitDigitFromRandomNumber(2));
    }

    @Test
    @DisplayName("숫자가 배열에 있을 때 true 반환")
    void has_containNumber() {
        Assertions.assertTrue(computerModel.hasContainNumber(1));

        Assertions.assertTrue(computerModel.hasContainNumber(2));

        Assertions.assertTrue(computerModel.hasContainNumber(3));
    }

    @Test
    @DisplayName("숫자가 배열에 없으면 false 반환")
    void has_notContainNumber() {
        Assertions.assertFalse(computerModel.hasContainNumber(4));
    }


}
