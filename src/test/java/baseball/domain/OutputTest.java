package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.io.Output;
import baseball.umpire.Result;
import org.junit.jupiter.api.Test;

class OutputTest {

    @Test
    void printResult() {
        //Given
        Result oneStrikeOneBall = new Result(1, 1);
        Result twoStrikeTwoBall = new Result(2, 2);
        Result threeStrike = new Result(3, 0);

        //When
        boolean test1 = Output.printResult(oneStrikeOneBall);
        boolean test2 = Output.printResult(twoStrikeTwoBall);
        boolean test3 = Output.printResult(threeStrike);

        //Then
        assertThat(test1).isEqualTo(true);
        assertThat(test2).isEqualTo(true);
        assertThat(test3).isEqualTo(false);
    }
}