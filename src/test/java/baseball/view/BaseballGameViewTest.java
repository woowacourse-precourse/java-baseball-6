package baseball.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static java.lang.Integer.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BaseballGameViewTest {

    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
        System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out); // 원상복귀
    }

    BaseballGameView baseballGameView = new BaseballGameView();

    @Test
    void anyBallAnyStrike () {
        // given
        HashMap<String, Integer> result = new HashMap<>();

        result.put("ball", 2);
        result.put("strike", 2);

        //when
        baseballGameView.displayResult(result);

        //then
        assertEquals("2볼 2스트라이크\n", outputMessage.toString());

    }

    @Test
    void noBallAnyStrike () {
        // given
        HashMap<String, Integer> result = new HashMap<>();

        result.put("ball", 0);
        result.put("strike", 2);

        //when
        baseballGameView.displayResult(result);

        //then
        assertEquals("2스트라이크\n", outputMessage.toString());

    }

    @Test
    void anyBallNoStrike () {
        // given
        HashMap<String, Integer> result = new HashMap<>();

        result.put("ball", 2);
        result.put("strike", 0);

        //when
        baseballGameView.displayResult(result);

        //then
        assertEquals("2볼\n", outputMessage.toString());

    }

    @Test
    void noBallNoStrike () {
        // given
        HashMap<String, Integer> result = new HashMap<>();

        result.put("ball", 0);
        result.put("strike", 0);

        //when
        baseballGameView.displayResult(result);

        //then
        assertEquals("낫싱\n", outputMessage.toString());

    }

    @Test
    void AllStrike () {
        // given
        HashMap<String, Integer> result = new HashMap<>();

        result.put("ball", 0);
        result.put("strike", 3);

        //when
        baseballGameView.displayResult(result);

        //then
        assertEquals("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n", outputMessage.toString());
    }

    @Test
    void restartGame () {
        // given
        String simulatedInput = "1";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        //when
        int restartInput = parseInt(baseballGameView.getUserRestartInput());

        //then
        assertEquals("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n", outputMessage.toString());
        assertThat(restartInput).isEqualTo(1);

        System.setIn(System.int);
    }

    @Test
    void startGame() {
        //given

        //when
        baseballGameView.displayStartMessage();

        //then
        assertEquals("숫자 야구 게임을 시작합니다.\n", outputMessage.toString());
    }


}