package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CompareTest {

    @Test
    public void compareNumberTest() {
        // Given
        Compare compare = new Compare();

        // Set computerNumList and getUserNumList for testing
        List<String> computerNumList = Arrays.asList("4", "2", "3");
        List<String> userNumList = Arrays.asList("1", "3", "2");

        // Set computer and user objects to use the custom lists
        compare.computer.computerNumList = computerNumList;
        compare.user.userNumList = userNumList;

        // When
        int[] result = compare.compareNumber(computerNumList, userNumList);

        // Then
        System.out.println(Arrays.toString(result)); // [볼, 스트라이크] 갯수 표시
    }
}
