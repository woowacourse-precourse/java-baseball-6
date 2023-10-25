package baseball;

public class GameController {
    private String randomNumber;
    private String userNumber;
    private String userAnswer;
    private boolean gameRunning = true;
    private int strike;
    private int ball;

    RandomNumberCreater randomNumberCreater = new RandomNumberCreater();
    GameOutputPrinter gameOutputPrinter = new GameOutputPrinter();
    GameInputReader gameInputReader = new GameInputReader();
    InputNumberChecker inputNumberChecker = new InputNumberChecker();
    OutputHintChecker outputHintChecker = new OutputHintChecker();

    public void play() {
        initializeGame();

        while(gameRunning) {
            getUserInput();
            checkInput();
            printHint();
            handleGameEnd();
        }
    }


    private void initializeGame() {
        gameOutputPrinter.printStartGame();
        randomNumber = randomNumberCreater.getRandomNumber();
    }

    private void getUserInput() {
        userNumber = gameInputReader.enterGameNumber();
        isValidUserNumberInput(userNumber);
    }

    private void checkInput() {
        strike = inputNumberChecker.checkStrike(randomNumber, userNumber);
        ball = inputNumberChecker.checkBall(randomNumber, userNumber);
    }

    private void printHint() {
        String hint = OutputHintChecker.getHint(strike, ball);
        System.out.println(hint);
    }

    private void handleGameEnd() {
        if (isGameEnd()) {
            restartOrEndGame();
        }
    }

    private void restartOrEndGame() {
        userAnswer = gameInputReader.enterAnswerRestartGame();
        isValidUserAnswerInput(userAnswer);

        if (userAnswer.equals("1")) {
            restartGame();
        } else {
            endGame();
        }
    }

    private void restartGame() {
        randomNumber = randomNumberCreater.getRandomNumber();
        gameRunning = true;
    }

    private void endGame() {
        gameRunning = false;
    }

    private boolean isGameEnd() {
        return strike == 3;
    }

    private void isValidUserNumberInput(String input) {
        InputValidator.isValidUserNumberInput(input);
    }

    private void isValidUserAnswerInput(String input) {
        InputValidator.isValidUserAnswerInput(input);
    }
}