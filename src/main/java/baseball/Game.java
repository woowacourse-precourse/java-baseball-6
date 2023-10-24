package baseball;

public class Game {
    String randomNumber;
    String userNumber;
    Boolean quit = true;

    public void play() {

        GameResultPrinter gameResultPrinter = new GameResultPrinter();
        gameResultPrinter.printStartGame();
        RandomNumberCreater randomNumberCreater = new RandomNumberCreater();

        randomNumber = randomNumberCreater.getRandomNumber();
        System.out.println(randomNumber);

        while(quit) {

            UserInputReader input = new UserInputReader();
            userNumber = input.enterGameNumber();

            CheckInputNumber checkInputNumber = new CheckInputNumber();

            int strike = checkInputNumber.checkStrike(randomNumber, userNumber);
            int ball = checkInputNumber.checkBall(randomNumber, userNumber);

            gameResultPrinter.printResult(strike, ball);

            if (strike == 3) {
                if (input.enterAnswerRestartGame().equals("1")) {
                    randomNumber = randomNumberCreater.getRandomNumber();
                    System.out.println(randomNumber);
                    quit = true;
                } else {
                    quit = false;
                }
            }
        }



    }


}
