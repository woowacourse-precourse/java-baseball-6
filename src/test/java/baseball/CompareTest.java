package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CompareTest {

    @Test
    public void compareNumberTest() {
        // Given
        Compare compare = new Compare();
        Judgement judgement = new Judgement();

        // Set computerNumList and getUserNumList for testing
        List<String> computerNumList = Arrays.asList("4", "2", "3");
        List<String> userNumList = Arrays.asList("1", "3", "2");

        // When
        int[] result = compare.compareNumbers(computerNumList, userNumList);

        // Then
        System.out.println(result[0] + " " + result[1]);
    }
}
