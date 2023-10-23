package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class OutputTest {

    Output output = new Output();

    @Test
    void printResult() {
        //Given
        int[] oneStrikeOneBall = {1, 1};
        int[] twoStrikeTwoBall = {2, 2};
        int[] threeStrike = {3, 0};

        //When
        boolean test1 = output.printResult(oneStrikeOneBall);
        boolean test2 = output.printResult(twoStrikeTwoBall);
        boolean test3 = output.printResult(threeStrike);

        //Then
        assertThat(test1).isEqualTo(true);
        assertThat(test2).isEqualTo(true);
        assertThat(test3).isEqualTo(false);
    }
}