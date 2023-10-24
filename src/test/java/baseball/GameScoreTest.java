package baseball;

import baseball.game.BallStrikeCount;
import baseball.game.GameScore;
import baseball.player.Computer;
import baseball.player.Person;
import baseball.util.generator.RandomGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GameScoreTest {
    private GameScore gameScore;

    @BeforeEach
    public void setUp() {
        RandomGenerator mockRandomGenerator = mock(RandomGenerator.class);

        when(mockRandomGenerator.pickNumberInRange(1, 9)).thenReturn(1, 2, 3);

        Person person = new Person();
        Computer computer = new Computer(mockRandomGenerator);

        person.insertNumberAndValidate("123");

        gameScore = new GameScore(person, computer);
    }

    @Test
    @DisplayName("점수 계산 테스트")
    public void testCalculateScore() {
        // 점수 계산
        BallStrikeCount result = gameScore.calculateScore();

        // 결과 검증
        assertEquals(3, result.getStrikeCount());
        assertEquals(0, result.getBallCount());
    }
}
