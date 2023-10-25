package baseball;

public class GameController {
    private String randomNumber;
    private String userNumber;
    private boolean quit = true;
    private int strike;
    private int ball;
    RandomNumberCreater randomNumberCreater = new RandomNumberCreater();
    GameOutputPrinter gameOutputPrinter = new GameOutputPrinter();
    GameInputReader gameInputReader = new GameInputReader();
    InputNumberChecker inputNumberChecker = new InputNumberChecker();

    public void play() {

        initializeGame();

        while(quit) {
            getUserInput();
            checkInput();

            printResult();

            if (strike == 3) {
                handleGameEnd();
            }
        }
    }

    private void initializeGame() {
        gameOutputPrinter.printStartGame();
        randomNumber = randomNumberCreater.getRandomNumber();
    }

    private void getUserInput() {
        userNumber = gameInputReader.enterGameNumber();
    }

    private void checkInput() {
        strike = inputNumberChecker.checkStrike(randomNumber, userNumber);
        ball = inputNumberChecker.checkBall(randomNumber, userNumber);
    }

    private void printResult() {
        gameOutputPrinter.printResult(strike, ball);
    }

    private void handleGameEnd() {
        if (gameInputReader.enterAnswerRestartGame().equals("1")) {
            RandomNumberCreater randomNumberCreater = new RandomNumberCreater();
            randomNumber = randomNumberCreater.getRandomNumber();
            System.out.println(randomNumber);
            quit = true;
        } else {
            quit = false;
        }
    }
}