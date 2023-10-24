//package baseball;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import java.util.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class ComputerTest {
//
//    private static Computer computer;
//
//    @BeforeAll
//    public static void setup(){ computer = new Computer(); }
//
//    @Test
//    public void testNumberValidation(){
//        for (int i = 0; i < 10000; i++){
//            computer.generateAnswer();
//            assertTrue(checkValidation(computer.getAnswerDigits()));
//        }
//    }
//
//    public boolean checkValidation(List<Character> answerDigits){
//        Set<Character> digits = new HashSet<>();
//        for(char digit: answerDigits){
//            digits.add(digit);
//        }
//        if (digits.size()!=3){
//            return false;
//        }
//        return true;
//    }
//
//    @Test
//    public void testGenerateAnswer(){
//        assertEquals("1스트라이크", computer.generateResult(Arrays.asList('1', '2', '3')));
//        assertEquals("1볼 1스트라이크", computer.generateResult(Arrays.asList('4', '5', '6')));
//        assertEquals("낫싱", computer.generateResult(Arrays.asList('7', '8', '9')));
//    }
//}
