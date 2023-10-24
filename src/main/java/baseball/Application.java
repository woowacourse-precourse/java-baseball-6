package baseball;


import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Printer printer = new Printer();
        InputHandler inputHandler = new InputHandler();
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
        NumberCounter numberCounter = new NumberCounter();
        List<Integer> computerNumber;
        List<Integer> userNumber;
        int strikes;
        int balls;

        //게임 시작
        printer.printStartingMessage();
        computerNumber = computerNumberGenerator.generateComputerNumber();
        while (true) {
            printer.printInputMessage();
            inputHandler.getUserInputNumber();
            userNumber = inputHandler.getUserNumber();
            inputHandler.isValidInputNumber(userNumber);

            strikes = numberCounter.countStrikes(computerNumber, userNumber);
            balls = numberCounter.countBalls(computerNumber, userNumber);
            printer.printResult(strikes, balls);
            userNumber = new ArrayList<>();

            //게임 승리
            if (strikes == 3) {
                printer.printEndingMessage();
                int userSelection = inputHandler.getUserSelection();

                inputHandler.isValidInputSelection(userSelection);

                if (userSelection == 1) {
                    computerNumber = computerNumberGenerator.generateComputerNumber();
                    continue;
                }
                if (userSelection == 2) {
                    break;
                }

            }

        }

    }
}
