package baseball.controller;

import baseball.model.Game;
import baseball.view.GameView;

import java.util.List;

public class ComputerController {
    private static final int NUMBER_LENGTH = 3;
    private static final int SUCCESS_STRIKE_COUNT = 3;
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private int strikeCount;
    private int ballCount;
    RandomNumber randomNumber = new RandomNumber();
    GameView gameView = new GameView();

    public void createRandomNumber(Game game){
        List<Integer> randomNumbers = randomNumber.createRandomNumbers();
        game.setRandomNumbers(randomNumbers);
    }

    public boolean compareAndCountStrike(Game game){
        List<Integer> userNumbers = game.getUserNumbers();
        List<Integer> randomNumbers = game.getRandomNumbers();

        compareNumberAndPrintMessage(userNumbers, randomNumbers);
        return strikeCount == SUCCESS_STRIKE_COUNT;
    }

    public void compareNumberAndPrintMessage(List<Integer> userNumbers, List<Integer> randomNumbers) {
        strikeCount = 0;
        ballCount = 0;
        countStrikeAndBall(userNumbers, randomNumbers);

        String message = "";

        message += getBallMessage();
        message += getStrikeMessage();
        message += getNothingMessage();

        gameView.printMessage(message);
    }

    public void countStrikeAndBall(List<Integer> userNumbers, List<Integer> randomNumbers){
        for (int i = 0; i<NUMBER_LENGTH; i++){
            countStrike(userNumbers.get(i), randomNumbers.get(i));
            countBall(randomNumbers, userNumbers.get(i), i);
        }
    }

    private void countStrike(int userNumber, int randomNumber) {
        if (userNumber == randomNumber) {
            strikeCount++;
        }
    }

    private void countBall(List<Integer> randomNumbers, int userNumber, int index) {
        if (randomNumbers.get(index) != userNumber && randomNumbers.contains(userNumber)) {
            ballCount++;
        }
    }

    public String getStrikeMessage(){
        if (strikeCount > 0) {
            return strikeCount + STRIKE_MESSAGE + " ";
        }
        return "";
    }

    public String getBallMessage(){
        if (ballCount > 0) {
            return ballCount + BALL_MESSAGE  + " ";
        }
        return "";
    }

    public String getNothingMessage(){
        if (strikeCount == 0 && ballCount == 0) {
            return NOTHING_MESSAGE;
        }
        return "";
    }

}
