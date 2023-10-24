package baseball;


import java.util.List;

public class Application {

    public static void main(String[] args) {
        Game.start();
        boolean isGameDone = false;
        boolean restart = true;

        while (restart) {
            isGameDone = false;
            List<Integer> threeUniqueNums = ComputerNumber.makeThreeUniqueNums();
            String computerNum = ComputerNumber.listToString(threeUniqueNums);
            while (!isGameDone) {
                String userInput = UserInput.readUserInput();
                String userNum = UserInput.checkUserInput(userInput);
                int balls = Hint.calBall(computerNum, userNum);
                int strikes = Hint.calStrike(computerNum, userNum);
                isGameDone = Hint.printHint(balls, strikes);
            }
            restart = Game.restartOrEnd();
        }
    }
}
