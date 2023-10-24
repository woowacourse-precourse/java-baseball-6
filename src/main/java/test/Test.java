package test;

import baseball.UserInput;
import baseball.GeneratingAnswer;
import baseball.ComparingInput;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        UserInputTest();
        GenerateAnswerTest();
        CompareInputTest();
    }

    public static void UserInputTest() {
        while(true) {
            UserInput userInput = new UserInput(3);
            List<Integer> tempInput = userInput.getInput();
            System.out.println(tempInput);
            if (tempInput.equals(List.of(1, 2, 3))) {
                break;
            }
        }
    }

    public static void GenerateAnswerTest(){
        for (int i = 0; i < 10; i ++) {
            GeneratingAnswer generatingAnswer = new GeneratingAnswer(3);
            System.out.println(generatingAnswer.generateAnswer());
        }
    }

    public static void CompareInputTest() {
        List<Integer> answer = List.of(1, 2, 3);
        UserInput userInput = new UserInput(3);
        ComparingInput comparingInput = new ComparingInput(answer, 3);
        for (int trial = 0; trial < 10; trial++) {
            List<Integer> temp = userInput.getInput();
            List<Integer> result = comparingInput.countMatch(temp);
            System.out.println(result);
        }
    }

}
