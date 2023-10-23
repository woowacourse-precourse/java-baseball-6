package test;
import baseball.UserInput;
import baseball.GenerateAnswer;

import java.util.List;

public class test {
    public static void main(String[] args){
        UserInputTest();
        GenerateAnswerTest();
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

}
