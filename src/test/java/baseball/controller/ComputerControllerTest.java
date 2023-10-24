package baseball.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.model.DecimalNumber;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerControllerTest {

    private final ComputerController computerController = new ComputerController(new DecimalNumber());
    private ByteArrayOutputStream output;

    @BeforeEach
    public void setUpStreams() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoresStreams() {
        System.setOut(System.out);
    }

    @Test
    public void 게임진행_낫싱() {
        //given
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> user = Arrays.asList(4, 5, 6);

        //when
        computerController.checkAnswer(computer, user);

        //then
        assertEquals("낫싱\n", output.toString());
    }

    @Test
    public void 게임진행_1볼_1스트라이크() {
        //given
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> user = Arrays.asList(1, 3, 7);

        //when
        computerController.checkAnswer(computer, user);

        //then
        assertEquals("1볼 1스트라이크\n", output.toString());
    }

    @Test
    public void 게임진행_2볼() {
        //given
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> user = Arrays.asList(7, 1, 2);

        //when
        computerController.checkAnswer(computer, user);

        //then
        assertEquals("2볼\n", output.toString());
    }

    @Test
    public void 게임진행_2스트라이크() {
        //given
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> user = Arrays.asList(1, 2, 7);

        //when
        computerController.checkAnswer(computer, user);

        //then
        assertEquals("2스트라이크\n", output.toString());
    }

    @Test
    public void 게임진행_3스트라이크() {
        //given
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> user = Arrays.asList(1, 2, 3);

        //when
        computerController.checkAnswer(computer, user);

        //then
        assertEquals("3스트라이크\n", output.toString());
    }
}