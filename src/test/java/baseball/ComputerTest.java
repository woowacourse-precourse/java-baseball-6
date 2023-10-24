package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;

public class ComputerTest {
    private Computer computer;
    private ByteArrayOutputStream outputStreamCaptor=new ByteArrayOutputStream();
    @BeforeEach
    void setUp(){
        computer = new Computer();

        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    void testGetNumberList_중복되지않는_세자리_숫자를_생성한다(){

        int digitCount = 3;
        computer = new Computer();

        var numberList = computer.getNumberList();
        Assertions.assertEquals(digitCount,numberList.size());

        HashSet<Integer> numberSet = new HashSet<>(numberList);
        Assertions.assertEquals(digitCount,numberSet.size());
    }
    @Test
    void testCheckUserNumberAndResponse_숫자가_전부_일치하면_참을_리턴한다(){
        var numberList = computer.getNumberList();

        int correctAnswer = 0;
        for (int number : numberList){
            correctAnswer = correctAnswer*10 + number;
        }

        // computer 가 가지는 숫자를 넣으므로 참이 나와야 한다.
        Assertions.assertTrue(computer.checkUserNumberAndResponse(correctAnswer));
    }
    @Test
    void testCheckUserNumberAndResponse_숫자가_하나라도_일치하지_않으면_거짓을_리턴한다(){
        var numberList = computer.getNumberList();

        StringBuilder wrongAnswerBuilder = new StringBuilder();
        for (int i =0; i<numberList.size();i++){
            wrongAnswerBuilder.append(0);
        }

        // 절대 나올수 없는 숫자를 넣으므로 거짓이 나와야 한다.
        int wrongAnswer = Integer.parseInt(wrongAnswerBuilder.toString());
        Assertions.assertFalse(computer.checkUserNumberAndResponse(wrongAnswer));
    }
    @Test
    void testPrintResultWithCount_숫자가_하나라도_일치하지_않으면_낫싱을_출력한다(){


        computer.printResult(0,0);

        String expectedAnswer = "낫싱";
        Assertions.assertEquals(expectedAnswer,outputStreamCaptor.toString().trim());
    }
    @Test
    void testPrintResultWithCount_볼카운트_또는_스트라이크카운트_가_있으면_출력한다(){
        int strikeCount = 3;
        int ballCount = 1;

        computer.printResult(strikeCount,ballCount);

        String expectedAnswer = ballCount+"볼 "+strikeCount+"스트라이크";
        Assertions.assertEquals(expectedAnswer,outputStreamCaptor.toString().trim());

    }
    @Test
    void testReGenerateNumberList_재생성된_숫자는_값이_다르다(){
        var existedNumberList = computer.getNumberList();
        computer.reGenerateNumberList();
        var createdNumberList = computer.getNumberList();

        Assertions.assertNotEquals(existedNumberList,createdNumberList);
    }
}
