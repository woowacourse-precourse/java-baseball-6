package baseball;

public class Game {
    private String randomNumber;
    private String userNumber;
    private boolean quit = true;
    private int strike;
    private int ball;

    public void play() {

        initializeGame();

        while(quit) {
            getUserInput();
            checkInput();

            // test 용
            printResult();

            if (strike == 3) {
                handleGameEnd();
            }
        }
    }

    private void initializeGame() {
        GameOutputPrinter gameOutputPrinter = new GameOutputPrinter();
        gameOutputPrinter.printStartGame();

        RandomNumberCreater randomNumberCreater = new RandomNumberCreater();
        randomNumber = randomNumberCreater.getRandomNumber();
    }

    private void getUserInput() {
        GameInputReader input = new GameInputReader();
        userNumber = input.enterGameNumber();
    }

    private void checkInput() {
        InputNumberChecker inputNumberChecker = new InputNumberChecker();
        strike = inputNumberChecker.checkStrike(randomNumber, userNumber);
        ball = inputNumberChecker.checkBall(randomNumber, userNumber);
    }

    private void printResult() {
        GameOutputPrinter gameOutputPrinter = new GameOutputPrinter();
        gameOutputPrinter.printResult(strike, ball);
    }

    private void handleGameEnd() {
        GameInputReader gameInputReader = new GameInputReader();
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