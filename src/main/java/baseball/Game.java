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
        GameResultPrinter gameResultPrinter = new GameResultPrinter();
        gameResultPrinter.printStartGame();

        RandomNumberCreater randomNumberCreater = new RandomNumberCreater();
        randomNumber = randomNumberCreater.getRandomNumber();
    }

    private void getUserInput() {
        UserInputReader input = new UserInputReader();
        userNumber = input.enterGameNumber();
    }

    private void checkInput() {
        CheckInputNumber checkInputNumber = new CheckInputNumber();
        strike = checkInputNumber.checkStrike(randomNumber, userNumber);
        ball = checkInputNumber.checkBall(randomNumber, userNumber);
    }

    private void printResult() {
        GameResultPrinter gameResultPrinter = new GameResultPrinter();
        gameResultPrinter.printResult(strike, ball);
    }

    private void handleGameEnd() {
        UserInputReader userInputReader = new UserInputReader();
        if (userInputReader.enterAnswerRestartGame().equals("1")) {
            RandomNumberCreater randomNumberCreater = new RandomNumberCreater();
            randomNumber = randomNumberCreater.getRandomNumber();
            System.out.println(randomNumber);
            quit = true;
        } else {
            quit = false;
        }
    }
}