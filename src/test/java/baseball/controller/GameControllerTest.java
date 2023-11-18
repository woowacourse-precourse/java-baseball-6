package baseball.controller;

import baseball.domain.Game;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameControllerTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private GameController gameController;

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @BeforeEach
    public void beforeEach() {
        System.setOut(new PrintStream(outputStreamCaptor));
        gameController = new GameController();
    }

    @AfterEach
    public void afterEach() {
        Console.close();
        System.setOut(standardOut);
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

    @Test
    @DisplayName("사용자가 정답을 맞출 때까지 계속 물어보는 지 확인한다.")
    void askUntilCorrectAnswer() {
        // given
        System.setIn(createUserInput("123\n456\n789"));

        List<Integer> computerAnswer = List.of(7, 8, 9);
        Game game = new Game(computerAnswer);

        // when
        gameController.askUntilCorrectAnswer(game);
        String result = outputStreamCaptor.toString();
        int count = countSomeWord(result, "숫자를 입력해주세요 : ");

        // then
        assertThat(count).isEqualTo(3);
    }

    public int countSomeWord(String target, String someWord) {
        return target.split(someWord).length - 1;
    }
}