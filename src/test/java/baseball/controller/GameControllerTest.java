package baseball.controller;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameControllerTest {
    private GameController gameController;

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @BeforeEach
    public void beforeEach() {
        gameController = new GameController();
    }

    @AfterEach
    public void afterEach() {
        Console.close();
    }

    @Test
    @DisplayName("askAnswer 메서드는 사용자 입력값을 변환하여 숫자 형태의 리스트로 반환한다.")
    void askAnswerShouldReturnUserNumbers() {
        // given
        System.setIn(createUserInput("123"));

        // when
        List<Integer> result = gameController.askAnswer();

        // then
        assertThat(result)
                .hasSize(3)
                .containsSubsequence(1, 2, 3);
    }
}