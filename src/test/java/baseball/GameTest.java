package baseball;

import baseball.domain.ComputerNumber;
import baseball.domain.UserNumber;
import baseball.excpetion.InputException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class GameTest {
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;
    final PlayGame gamePlay = new PlayGame();
    final ComputerNumber computerNumber = new ComputerNumber();
    final InputException numberException = new InputException();

    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @AfterEach
    void tearDown(){
        System.setOut(standardOut);
    }

    @Test
    void 결과_값이_스트라이크() {
        // given
        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(1,7,4));
        List<Integer> userNumber = new ArrayList<>(Arrays.asList(1,7,8));
        // when
        gamePlay.getResult(userNumber,computerNumber);
        // then
        Assertions.assertEquals("2스트라이크",outputStreamCaptor.toString().trim());
    }

    @Test
    void 결과_값이_볼(){
        // given
        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(2,5,9));
        List<Integer> userNumber = new ArrayList<>(Arrays.asList(5,9,2));
        // when
        gamePlay.getResult(userNumber,computerNumber);
        // then
        Assertions.assertEquals("3볼",outputStreamCaptor.toString().trim());

    }
    @Test
    void 결과_값이_볼과_스트라이크(){
        // given
        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(3,6,8));
        List<Integer> userNumber = new ArrayList<>(Arrays.asList(3,8,9));
        // when
        gamePlay.getResult(userNumber,computerNumber);
        // then
        Assertions.assertEquals("1볼 1스트라이크",outputStreamCaptor.toString().trim());

    }
    @Test
    void 결과_값이_올_스트라이크(){
        // given
        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(3,5,7));
        List<Integer> userNumber = new ArrayList<>(Arrays.asList(3,5,7));
        // when
        boolean result = gamePlay.getResult(userNumber,computerNumber);
        // then
        Assertions.assertEquals(false,result);
    }
    @Test
    void 결과_값이_낫싱(){
        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(1,5,9));
        List<Integer> userNumber = new ArrayList<>(Arrays.asList(2,4,8));
        gamePlay.getResult(userNumber,computerNumber);
        Assertions.assertEquals("낫싱",outputStreamCaptor.toString().trim());
    }
    @Test
    void 컴퓨터의_숫자가_3자리(){
        List<Integer> computerNumberList = computerNumber.generateNumber();
        assertThat(computerNumberList.size()).isEqualTo(3);
    }
    @Test
    void 컴퓨터의_숫자가_중복(){
        List<Integer> computerNumberList = computerNumber.generateNumber();
        Set<Integer> uniqueList = new HashSet<>(computerNumberList);
        assertThat(uniqueList.size()).isEqualTo(3);
    }
    @Test
    void 컴퓨터의_숫자가_범위내에서_구성(){
        List<Integer> computerNumberList = computerNumber.generateNumber();
        for(int i=0; i<computerNumberList.size(); i++) {
            assertThat(computerNumberList.get(i)).isBetween(1,9);
        }
    }
    @Test
    void 사용자의_숫자가_3자리(){
        String userInput = "15834";
        assertThatThrownBy(()-> numberException.validNumberLength(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 사용자의_숫자가_중복(){
        String userInput = "112";
        assertThatThrownBy(()-> numberException.validDuplicateNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 사용자의_숫자가_범위내에서_구성(){
        String userInput = "015";
        assertThatThrownBy(()-> numberException.validNumberType(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_선택(){
        String optionInput = "3";
        assertThatThrownBy(() -> numberException.validOption(optionInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
