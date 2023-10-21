package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerTest {
    private Computer computer;
    @BeforeEach
    void setUp(){
        computer = new Computer();
    }
    @Test
    void 중복되지않는_세자리_숫자를_생성한다(){

        int digitCount = 3;
        computer = new Computer(digitCount);

        // 숫자 리스트는 숫자 세개를 가지고 있다.
        var numberList = computer.getNumberList();
        assertEquals(digitCount,numberList.size());

        // 중복된 숫자가 없어야 한다.
        HashSet<Integer> numberSet = new HashSet<>(numberList);
        assertEquals(digitCount,numberSet.size());
    }
    @Test
    void testCheckUserNumberAndResponse_숫자가_전부_일치하면_참을_리턴한다(){
        var numberList = computer.getNumberList();

        int correctAnswer = 0;
        for (int number : numberList){
            correctAnswer = correctAnswer*10 + number;
        }

        // computer 가 가지는 숫자를 넣었으므로 참이 나와야 한다.
        assertEquals(true,computer.checkUserNumberAndResponse(correctAnswer));
    }
    @Test
    void testCheckUserNumberAndResponse_숫자가_하나라도_일치하지_않으면_거짓을_리턴한다(){
        var numberList = computer.getNumberList();

        StringBuilder wrongAnswerBuilder = new StringBuilder();
        for (int i =0; i<numberList.size();i++){
            wrongAnswerBuilder.append(0);
        }

        // 절대 나올수 없는 숫자를 넣었으므로 거짓이 나와야 한다.
        int wrongAnswer = Integer.parseInt(wrongAnswerBuilder.toString());
        assertEquals(false,computer.checkUserNumberAndResponse(wrongAnswer));
    }
    @Test
    void testPrintResultWithCount_숫자가_하나라도_일치하지_않으면_낫싱을_출력한다(){
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        computer.printResultWithCount(0,0);

        String expectedAnswer = "낫싱";
        Assertions.assertEquals(expectedAnswer,outputStreamCaptor.toString().trim());
    }
    @Test
    void testPrintResultWithCount_볼카운트_또는_스트라이크카운트_가_있으면_출력한다(){
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        int strikeCount = 3;
        int ballCount = 1;

        computer.printResultWithCount(strikeCount,ballCount);

        String expectedAnswer = ballCount+"볼 "+strikeCount+"스트라이크";
        Assertions.assertEquals(expectedAnswer,outputStreamCaptor.toString().trim());

    }
}
