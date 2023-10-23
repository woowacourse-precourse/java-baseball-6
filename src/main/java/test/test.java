package test;
import baseball.UserInput;
import baseball.GenerateAnswer;
import baseball.CompareInput;

import java.util.List;

public class test {
    public static void main(String[] args){
        UserInputTest();
        GenerateAnswerTest();
        CompareInputTest();
    }

    public static void UserInputTest(){
        while(true) {
            UserInput userInput = new UserInput(3);
            List<Integer> temp = userInput.getInput();
            System.out.println(temp);
            if (temp.equals(List.of(1, 2, 3))){
                break;
            }
        }
    }

    public static void GenerateAnswerTest(){
        for (int i = 0; i < 10; i ++){
            GenerateAnswer generateAnswer = new GenerateAnswer(3);
            System.out.println(generateAnswer.genAnswer());
        }
    }

    public static void CompareInputTest(){
        List<Integer> answer = List.of(1, 2, 3);
        UserInput userInput = new UserInput(3);
        CompareInput compareInput = new CompareInput(answer, 3);
        for (int i = 0; i < 10; i++){
            List<Integer> temp = userInput.getInput();
            List<Integer> result = compareInput.countMatch(temp);
            System.out.println(result);
        }
    }

}
