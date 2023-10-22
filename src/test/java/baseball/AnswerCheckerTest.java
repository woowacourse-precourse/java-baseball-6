package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnswerCheckerTest {

    AnswerChecker answerChecker = new AnswerChecker();

    @Test
    void 정답맞출시() {
        //given
        List<Integer> computerAnswer = List.of(1, 2, 3);
        List<Integer> myAnswer = List.of(1, 2, 3);

        //when
        String GameResult = answerChecker.checkAnswer(computerAnswer, myAnswer);

        //then
        assertThat(GameResult).isEqualTo("03");
    }

    @Test
    void 볼2스트라이크1일때() {
        //given
        List<Integer> computerAnswer = List.of(4, 5, 6);
        List<Integer> myAnswer = List.of(6, 5, 4);

        //when
        String GameResult = answerChecker.checkAnswer(computerAnswer, myAnswer);

        //then
        assertThat(GameResult).isEqualTo("21");
    }

    @Test
    void printResult_낫싱테스트() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String gameResult = "00";

        //when
        answerChecker.printResult(gameResult);


        //then
        assertThat(out.toString()).contains("낫싱");
    }

    @Test
    void printResult_볼테스트() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String gameResult = "20";

        //when
        answerChecker.printResult(gameResult);


        //then
        assertThat(out.toString()).contains("2볼");
    }

    @Test
    void printResult_스트라이크테스트() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String gameResult = "02";

        //when
        answerChecker.printResult(gameResult);


        //then
        assertThat(out.toString()).contains("2스트라이크");
    }

    @Test
    void printResult_볼스트라이크테스트() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String gameResult = "21";

        //when
        answerChecker.printResult(gameResult);


        //then
        assertThat(out.toString()).contains("2볼 1스트라이크");
    }
}