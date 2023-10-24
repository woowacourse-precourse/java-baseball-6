package baseball.model.computer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.model.player.GuessNumber;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    private Computer computer;
    private Score score;
    private GameAnswer gameAnswer;

    @BeforeEach
    void init() {
        gameAnswer = new GameAnswer();
        score = new Score();
        computer = new Computer(gameAnswer, score);
    }

    @Test
    @DisplayName("initScore 메소드 호출 시 strike, ball 값은 0 이어야 한다.")
    void testInitScore() {
        // given
        computer.makeAnswer();
        List<GuessNumber> playerInput = playerGuessAnswer(1, 2, 3);
        computer.calculateScore(playerInput);

        // when
        computer.initScore();
        Score score = computer.getScore();

        // then
        assertEquals(0, score.getStrike());
        assertEquals(0, score.getBall());
    }

    @Test
    @DisplayName("컴퓨터는 3개의 난수를 생성한다.")
    void makeAnswer_Test() {
        // given
        computer.makeAnswer();

        // when
        List<Integer> answer = computer.getGameAnswer();

        // then
        assertNotNull(answer);
        assertEquals(3, answer.size());
    }

    @Test
    @DisplayName("낫싱 점수 계산 테스트")
    void calculateScoreTest_Nothing() throws Exception {
        // given
        computerMakeAnswer(List.of(1, 2, 3));

        // when
        List<GuessNumber> playerInput = playerGuessAnswer(4, 5, 6);
        computer.calculateScore(playerInput);

        // then
        assertEquals(score.getBall(), 0);
        assertEquals(score.getStrike(), 0);
    }

    @Test
    @DisplayName("1스트라이크 점수 계산 테스트")
    void calculateScoreTest_OneStrike() throws Exception {
        // given
        computerMakeAnswer(List.of(1, 2, 3));

        // when
        List<GuessNumber> playerInput = playerGuessAnswer(1, 5, 6);
        computer.calculateScore(playerInput);

        // then
        assertEquals(score.getBall(), 0);
        assertEquals(score.getStrike(), 1);
    }

    @Test
    @DisplayName("2스트라이크 점수 계산 테스트")
    void calculateScoreTest_TwoStrike() throws Exception {
        // given
        computerMakeAnswer(List.of(1, 2, 3));

        // when
        List<GuessNumber> playerInput = playerGuessAnswer(1, 2, 5);
        computer.calculateScore(playerInput);

        // then
        assertEquals(score.getBall(), 0);
        assertEquals(score.getStrike(), 2);
    }

    @Test
    @DisplayName("3스트라이크 점수 계산 테스트")
    void calculateScoreTest_ThreeStrike() throws Exception {
        // given
        computerMakeAnswer(List.of(1, 2, 3));

        // when
        List<GuessNumber> playerInput = playerGuessAnswer(1, 2, 3);
        computer.calculateScore(playerInput);

        // then
        assertEquals(score.getBall(), 0);
        assertEquals(score.getStrike(), 3);
    }

    @Test
    @DisplayName("1볼 점수 계산 테스트")
    void calculateScoreTest_OneBall() throws Exception {
        // given
        computerMakeAnswer(List.of(1, 2, 3));

        // when
        List<GuessNumber> playerInput = playerGuessAnswer(4, 5, 1);
        computer.calculateScore(playerInput);

        // then
        assertEquals(score.getBall(), 1);
        assertEquals(score.getStrike(), 0);
    }

    @Test
    @DisplayName("2볼 점수 계산 테스트")
    void calculateScoreTest_TwoBall() throws Exception {
        // given
        computerMakeAnswer(List.of(1, 2, 3));

        // when
        List<GuessNumber> playerInput = playerGuessAnswer(3, 4, 1);
        computer.calculateScore(playerInput);

        // then
        assertEquals(score.getBall(), 2);
        assertEquals(score.getStrike(), 0);
    }

    @Test
    @DisplayName("3볼 점수 계산 테스트")
    void calculateScoreTest_ThreeBall() throws Exception {
        // given
        computerMakeAnswer(List.of(1, 2, 3));

        // when
        List<GuessNumber> playerInput = playerGuessAnswer(3, 1, 2);
        computer.calculateScore(playerInput);

        // then
        assertEquals(score.getBall(), 3);
        assertEquals(score.getStrike(), 0);
    }

    @Test
    @DisplayName("1볼 1스트라이크 점수 계산 테스트")
    void calculateScoreTest_OneBall_OneStrike() throws Exception {
        // given
        computerMakeAnswer(List.of(1, 2, 3));

        // when
        List<GuessNumber> playerInput = playerGuessAnswer(1, 3, 5);
        computer.calculateScore(playerInput);

        // then
        assertEquals(score.getBall(), 1);
        assertEquals(score.getStrike(), 1);
    }

    @Test
    @DisplayName("2볼 1스트라이크 점수 계산 테스트")
    void calculateScoreTest_TwoBall_OneStrike() throws Exception {
        // given
        computerMakeAnswer(List.of(1, 2, 3));

        // when
        List<GuessNumber> playerInput = playerGuessAnswer(1, 3, 2);
        computer.calculateScore(playerInput);

        // then
        assertEquals(score.getBall(), 2);
        assertEquals(score.getStrike(), 1);
    }

    @Test
    @DisplayName("3 스트라이크인 경우 isAllStrike()는 true를 리턴해야 한다.")
    void isAllStrikeTest() throws Exception {
        // given
        computerMakeAnswer(List.of(1, 2, 3));

        // when
        List<GuessNumber> playerInput = playerGuessAnswer(1, 2, 3);
        computer.calculateScore(playerInput);

        // then
        assertTrue(score.isAllStrike());
    }

    List<GuessNumber> playerGuessAnswer(Integer first, Integer second, Integer third) {
        List<GuessNumber> playerInput = new ArrayList<>();

        playerInput.add(new GuessNumber(first));
        playerInput.add(new GuessNumber(second));
        playerInput.add(new GuessNumber(third));

        return playerInput;
    }

    private void computerMakeAnswer(List<Integer> answer) throws NoSuchFieldException, IllegalAccessException {
        Field answerField = gameAnswer.getClass().getDeclaredField("answer");
        answerField.setAccessible(true);
        answerField.set(gameAnswer, answer);
    }
}