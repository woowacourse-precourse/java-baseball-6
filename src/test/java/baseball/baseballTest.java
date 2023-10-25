package baseball;

import baseball.controller.BaseballController;
import baseball.domain.ComputerNumber;
import baseball.domain.PlayerNumber;
import baseball.exception.InputException;
import baseball.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class baseballTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;
    final PlayGame playGame = new PlayGame();
    final BaseballController baseballController = new BaseballController();
    final ComputerNumber computerNumber = new ComputerNumber();
    final InputException inputException = new InputException();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }
    @Test
    void 결과가_볼() {
        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(1,2,5));
        List<Integer> playerNumber = new ArrayList<>(Arrays.asList(2,5,1));
        int ball = playGame.checkBall(computerNumber,playerNumber);
        Assertions.assertEquals(3,ball);
        }
    @Test
    void 결과가_스트라이크() {
        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(1,2,5));
        List<Integer> playerNumber = new ArrayList<>(Arrays.asList(1,2,4));
        int strike = playGame.checkStrike(computerNumber,playerNumber);
        Assertions.assertEquals(2,strike);
    }
    @Test
    void 결과가_스트라이크와_볼() {
        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(7,8,9));
        List<Integer> playerNumber = new ArrayList<>(Arrays.asList(7,9,5));
        int strike = playGame.checkStrike(computerNumber,playerNumber);
        int ball = playGame.checkBall(computerNumber,playerNumber);
        baseballController.judgeResult(strike,ball);
        Assertions.assertEquals("1볼 1스트라이크",outputStreamCaptor.toString().trim());
    }

    @Test
    void 결과가_낫싱() {
        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> playerNumber = new ArrayList<>(Arrays.asList(6,4,5));
        int strike = playGame.checkStrike(computerNumber,playerNumber);
        int ball = playGame.checkBall(computerNumber,playerNumber);
        baseballController.judgeResult(strike,ball);
        Assertions.assertEquals("낫싱",outputStreamCaptor.toString().trim());
    }

    @Test
    void 컴퓨터_숫자가_세자리() {
        List<Integer> computerNumberList = computerNumber.generateNumber();
        assertThat(computerNumberList.size()).isEqualTo(3);
    }

    @Test
    void 컴퓨터_숫자가_1부터_9_사이_숫자로_구성() {
        List<Integer> computerNumberList = computerNumber.generateNumber();
        for(int i=0; i<computerNumberList.size(); i++) {
            assertThat(computerNumberList.get(i)).isBetween(1,9);
        }
    }

    @Test
    void 컴퓨터_숫자가_중복이_아님() {
        List<Integer> computerNumberList = computerNumber.generateNumber();
        Set<Integer> uniqueList = new HashSet<>(computerNumberList);
        assertThat(uniqueList.size()).isEqualTo(3);
        }
        
}


