package baseball;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ComputerTest {
    private final Computer computer = new Computer();
    ByteArrayOutputStream testOut = new ByteArrayOutputStream();
    @Test
    void 난수생성중복검사(){
        for(int i = 0; i < 100; i++) {

            Numbers numbers = computer.initComputerNumbers();
            List<Number> duplicateCheck = new ArrayList();
            for(int j = 0; j < 3; j++){
                Assertions.assertThat(duplicateCheck.contains(numbers.getNumberByIndex(j))).isFalse();
                duplicateCheck.add(numbers.getNumberByIndex(j));
            }
        }
    }

    @Test
    void 판정테스트(){
        System.setOut(new PrintStream(testOut));
        Numbers computerNumbers = makeNumbers(new int[] {1, 2, 3});
        assertJudgeResultOutput(makeNumbers(new int[] {1, 2, 3}), computerNumbers,"3스트라이크\n");
        assertJudgeResultOutput(makeNumbers(new int[] {2, 3, 1}), computerNumbers,"3볼\n");
        assertJudgeResultOutput(makeNumbers(new int[] {3, 5, 6}), computerNumbers,"1볼\n");
        assertJudgeResultOutput(makeNumbers(new int[] {1, 3, 6}), computerNumbers,"1볼 1스트라이크\n");
        assertJudgeResultOutput( makeNumbers(new int[] {3, 2, 1}), computerNumbers,"2볼 1스트라이크\n");
    }
    Numbers makeNumbers(int[] list){
        Numbers numbers = new Numbers();
        for(int number : list){
            numbers.addNumber(new Number(number));
        }
        return numbers;
    }
    void assertJudgeResultOutput(Numbers userNumbers, Numbers computerNumbers, String outputToCompare){
        Judgement result = new Judgement(userNumbers, computerNumbers);
        result.printResult();
        Assertions.assertThat(testOut.toString()).isEqualTo(outputToCompare);
        testOut.reset();
    }

}
