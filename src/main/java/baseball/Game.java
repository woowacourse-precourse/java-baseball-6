package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    String randomNumber;
    String userNumber;
    Boolean quit = true;

    public void play() {

        Output output = new Output();
        output.printStartGame();
        RandomNumberCreater randomNumberCreater = new RandomNumberCreater();

        randomNumber = randomNumberCreater.getRandomNumber();
        System.out.println(randomNumber);

        while(quit) {

            Input input = new Input();
            userNumber = input.enterGameNumber();

            CheckInputNumber checkInputNumber = new CheckInputNumber();

            int strike = checkInputNumber.checkStrike(randomNumber, userNumber);
            int ball = checkInputNumber.checkBall(randomNumber, userNumber);

            output.printResult(strike, ball);

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
