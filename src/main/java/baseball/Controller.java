package baseball;

import java.util.List;

public class Controller {

    public Controller(){}

    public static void init(int digits){
        UserInput userInput = new UserInput(digits);
        OutputView.printStart();
        round(digits, userInput);
        boolean gameState = restart(userInput);
        while(gameState){
            round(digits, userInput);
            gameState = restart(userInput);
        }
    }

    public static void round(int digits, UserInput userInput){
        GenerateAnswer genAns = new GenerateAnswer(digits);
        List<Integer> genAnswer = genAns.genAnswer();
        CompareInput compareInput = new CompareInput(genAnswer, digits);
        while(true) {
            OutputView.printInput();
            List<Integer> userValue = userInput.getInput();
            List<Integer> ballCount = compareInput.countMatch(userValue);
            OutputView.printResult(ballCount);
            if (ballCount.equals(List.of(0, 3))){
                break;
            }
        }
    }

    public static boolean restart(UserInput userInput){
        OutputView.printRestart();
        return userInput.getRestart().equals("1");
    }
}
