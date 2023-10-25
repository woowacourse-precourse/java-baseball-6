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
        userAnswer = gameInputReader.enterAnswerRestartGame();
        isValidUserAnswerInput(userAnswer);
        if (userAnswer.equals("1")) {
            RandomNumberCreater randomNumberCreater = new RandomNumberCreater();
            randomNumber = randomNumberCreater.getRandomNumber();
            gameRunning = true;
        } else {
            gameRunning = false;
        }
    }

    private void isValidUserNumberInput(String input) {
        InputValidator.isValidUserNumberInput(input);
    }

    private void isValidUserAnswerInput(String input) {
        InputValidator.isValidUserAnswerInput(input);
    }
}