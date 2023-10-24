package baseball.domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameServiceTest {

    private GameService gameService;

    @Test
    @DisplayName("동일한 싱글톤 인스턴스를 반환합니다.")
    void getInstance() {
        // GIVEN
        GameService instance1 = GameService.getInstance();

        // WHEN
        GameService instance2 = GameService.getInstance();

        // THEN
        assertThat(instance1).isEqualTo(instance2);
    }

    @BeforeEach
    void setUp() {
        gameService = GameService.getInstance();
    }

    @AfterEach
    void tearDown() {
        GameService.clearInstance();
    }

    @Test
    void hasGameEnded() {
        // GIVEN
        // randomNumbers 생성
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(1);
        randomNumbers.add(2);
        randomNumbers.add(3);
        // 정답 문자열 입력
        String userAnswer = "123";
        InputStream answerStream = new ByteArrayInputStream(userAnswer.getBytes());
        System.setIn(answerStream);
        // 재시작 여부 입력
        String restartOption = "2";
        InputStream restartStream = new ByteArrayInputStream(restartOption.getBytes());
        System.setIn(restartStream);

        // WHEN
        boolean isGameEnded = gameService.hasGameEnded(randomNumbers);

        // THEN
        assertThat(isGameEnded).isTrue();
    }

    @Test
    void doBaseballGame() {

    }

    @Test
    void hasRightAnswer() {
    }

    @Test
    void getUserAnswerInputs() {
    }
}