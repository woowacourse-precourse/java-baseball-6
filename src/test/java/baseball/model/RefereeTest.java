package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RefereeTest {
    private Referee referee = new Referee();

    @Test
    public void compareComputerPlayer_ShouldReturnTrueForMatchingLists() {
        List<Integer> computerNumber = Arrays.asList(1, 2, 3);
        List<Integer> playerNumber = Arrays.asList(1, 2, 3);

        boolean result = referee.compareComputerPlayer(computerNumber, playerNumber);

        assertEquals(true, result);
    }

    @Test
    public void compareComputerPlayer_ShouldReturnFalseForNonMatchingLists() {
        List<Integer> computerNumber = Arrays.asList(1, 2, 3);
        List<Integer> playerNumber = Arrays.asList(4, 5, 6);

        boolean result = referee.compareComputerPlayer(computerNumber, playerNumber);

        assertEquals(false, result);
    }

    @Test
    public void calculateBall_ShouldReturnCorrectBallCount() {
        List<Integer> computerNumber = Arrays.asList(1, 2, 3);
        List<Integer> playerNumber = Arrays.asList(3, 1, 5);

        int result = referee.calculateBall(computerNumber, playerNumber);

        assertEquals(2, result);
    }

    @Test
    public void calculateBall_ShouldReturnZeroForNoBalls() {
        List<Integer> computerNumber = Arrays.asList(1, 2, 3);
        List<Integer> playerNumber = Arrays.asList(4, 5, 6);

        int result = referee.calculateBall(computerNumber, playerNumber);

        assertEquals(0, result);
    }

    @Test
    public void calculateStrike_ShouldReturnCorrectStrikeCount() {
        List<Integer> computerNumber = Arrays.asList(1, 2, 3);
        List<Integer> playerNumber = Arrays.asList(1, 5, 6);

        int result = referee.calculateStrike(computerNumber, playerNumber);

        assertEquals(1, result);
    }

    @Test
    public void calculateStrike_ShouldReturnZeroForNoStrikes() {
        List<Integer> computerNumber = Arrays.asList(1, 2, 3);
        List<Integer> playerNumber = Arrays.asList(4, 5, 6);

        int result = referee.calculateStrike(computerNumber, playerNumber);

        assertEquals(0, result);
    }
}
