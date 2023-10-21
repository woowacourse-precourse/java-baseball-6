package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class GameManagerTest {
    @Test
    void 스트라이크가_3개인_경우() {
        // Arrange
        List<Integer> computerNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(1, 2, 3);
        GameManager gameManager = new GameManager();
        // Action
        String result = gameManager.isEndGame(computerNumber, userNumber);
        // Assert
        assertThat(result).isEqualTo("3스트라이크");
    }

    @Test
    void 스트라이크가_1개_이상인_경우() {
        // Arrange
        List<Integer> computerNumber = List.of(1, 3, 2);
        List<Integer> userNumber = List.of(1, 2, 4);
        GameManager gameManager = new GameManager();
        // Action
        String result = gameManager.isEndGame(computerNumber, userNumber);
        // Assert
        assertThat(result).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 스트라이크가_0개_이고_볼이_1개_이상인_경우() {
        // Arrange
        List<Integer> computerNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(2, 3, 4);
        GameManager gameManager = new GameManager();
        // Action
        String result = gameManager.isEndGame(computerNumber, userNumber);
        // Assert
        assertThat(result).isEqualTo("2볼");
    }

    @Test
    void 스트라이크와_볼이_없는_경우() {
        // Arrange
        List<Integer> computerNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(4, 5, 6);
        GameManager gameManager = new GameManager();
        // Action
        String result = gameManager.isEndGame(computerNumber, userNumber);
        // Assert
        assertThat(result).isEqualTo("낫싱");
    }
}