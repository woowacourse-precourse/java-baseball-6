package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OutputTest {

    Output output = new Output();

    @Test
    void printResult() {
        //Given
        int[] oneStrikeOneBall = {1, 1};
        int[] twoStrikeTwoBall = {2, 2};
        int[] threeStrike = {3,0};

        //When
        int test1 = output.printResult(oneStrikeOneBall);
        int test2 = output.printResult(twoStrikeTwoBall);
        int test3 = output.printResult(threeStrike);

        //Then
        assertThat(test1).isEqualTo(1);
        assertThat(test2).isEqualTo(2);
        assertThat(test3).isEqualTo(3);
    }
}