package baseball;

public class Game {
    private String randomNumber;
    private String userNumber;
    private boolean quit = true;
    private int strike;
    private int ball;

    public void play() {
        initializeGame();

        while (quit) {
            if (getUserInput() == false) {
                break;
            }
            checkInput();
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

    private boolean getUserInput() {
        UserInputReader input = new UserInputReader();
        userNumber = input.enterGameNumber();

        boolean isValidNumber = isValidUserNumberInput(userNumber);

        return isValidNumber;
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
        String inputAnswer = userInputReader.enterAnswerRestartGame();

        if (!isValidUserAnswerInput(inputAnswer)) {
            System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
            quit = false;
            return;
        }

        if (inputAnswer.equals("1")) {
            RandomNumberCreater randomNumberCreater = new RandomNumberCreater();
            randomNumber = randomNumberCreater.getRandomNumber();
            System.out.println(randomNumber);
        } else {
            quit = false;
        }
    }

    private boolean isValidUserNumberInput(String inputNumber) {
        try {
            InputValidator.isValidUserNumberInput(inputNumber);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean isValidUserAnswerInput(String inputAnswer) {
        try {
            InputValidator.isValidUserAnswerInput(inputAnswer);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}