package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ResultTest {
    @Test
    void testTwoBallCalculation() {
        int answer = 316;
        int input = 123;

        Result result = Result.calculate(String.valueOf(input), String.valueOf(answer));

        assertEquals(2, result.getBall());
    }

    @Test
    void testOneBallOneStrikeCalculation() {
        int answer = 316;
        int input = 236;

        Result result = Result.calculate(String.valueOf(input), String.valueOf(answer));

        assertEquals(1, result.getBall());
        assertEquals(1, result.getStrike());
    }


    @Test
    void testThreeStrikeCalculation() {
        int answer = 316;
        int input = 316;

        Result result = Result.calculate(String.valueOf(input), String.valueOf(answer));

        assertEquals(3, result.getStrike());
    }


    @Test
    void testNothingCalculation() {
        int answer = 316;
        int input = 789;

        Result result = Result.calculate(String.valueOf(input), String.valueOf(answer));

        assertEquals(0, result.getBall());
        assertEquals(0, result.getStrike());
    }

}