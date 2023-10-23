package baseball;

public class Game {
    String randomNumber;
    String userNumber;

    public void play() {
        Output output = new Output();
        output.printStartGame();

        RandomNumberCreater randomNumberCreater = new RandomNumberCreater();

        randomNumber = randomNumberCreater.getRandomNumber();
        System.out.println(randomNumber);

        Input input = new Input();
        userNumber = input.enterGameNumber();

        CheckInputNumber checkInputNumber = new CheckInputNumber();

        int strike = checkInputNumber.checkStrike(randomNumber, userNumber);
        int ball = checkInputNumber.checkBall(randomNumber, userNumber);

        System.out.println(strike + " " + ball);


    }


}
