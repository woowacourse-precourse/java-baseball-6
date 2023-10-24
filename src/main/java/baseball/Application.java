package baseball;


import java.util.List;

public class Application {

    public static void main(String[] args) {
        Game.start();
        boolean isGameDone = false;

        while (!isGameDone) {
            List<Integer> uniqueThreeNumbers = ComputerNumber.makeUniqueThreeNumbers();
            String computerNum = ComputerNumber.listToString(uniqueThreeNumbers);
            String userInput = UserInput.readUserInput();
            String userNum = UserInput.checkUserInput(userInput);
            int balls = Hint.calBall(computerNum, userNum);
            int strikes = Hint.calStrike(computerNum, userNum);
            isGameDone = Hint.printHint(balls, strikes);
        }
    }
}
