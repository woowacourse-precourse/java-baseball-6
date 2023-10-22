package baseball;


public class Application {

    public static void main(String[] args) {
        Game.start();
        boolean isGameDone = false;

        while (!isGameDone) {
            String computerNum = ComputerNumber.makeNumber();
            String userInput = UserInput.readUserInput();
            String userNum = UserInput.checkUserInput(userInput);
            HintCountDto hintCountDto = Hint.calHint(computerNum, userNum);
            isGameDone = Hint.printHint(hintCountDto);
        }
    }
}
