package test;
import baseball.UserInput;

public class test {
    public static void UserInputTest(){
        while(true) {
            UserInput userInput = new UserInput();
            int temp = userInput.getInput();
            System.out.println(temp);
            if (temp == 123){
                break;
            }
        }
    }
    public static void main(String[] args){
        UserInputTest();
    }

}
