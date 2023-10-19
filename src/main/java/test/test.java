package test;
import baseball.UserInput;
import baseball.GenerateAnswer;

public class test {
    public static void main(String[] args){
        UserInputTest();
        GenerateAnswerTest();
    }

    public static void UserInputTest(){
        while(true) {
            UserInput userInput = new UserInput(3);
            int temp = userInput.getInput();
            System.out.println(temp);
            if (temp == 123){
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
