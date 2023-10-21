package controller;

import model.GameNumber;
import view.OutputView;

import java.util.List;

/**
 * packageName    : controller
 * fileName       : ComputerController
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-19        qkrtn_ulqpbq2       최초 생성
 */
public class ComputerController {

    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    private static final int BASEBALL_SUCCESS_STRIKE_COUNT = 3;
    private static final int INIT_ZERO = 0;
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String SPACING_MESSAGE = " ";
    private int strikeCount;
    private int ballCount;
    OutputView outputView = new OutputView();

    RandomController random = new RandomController();
    public void startGame(GameNumber gameNumber) {
        List<Integer> computerNumbers = random.generateRandomNumbers();
        gameNumber.setComputerNumbers(computerNumbers);
    }

    public boolean threeStrike(GameNumber gameNumber){
        List<Integer> playerNumbers = gameNumber.getPlayerNumbers();
        List<Integer> computerNumbers = gameNumber.getComputerNumbers();

        return compareNumbers(playerNumbers, computerNumbers);
    }

    public boolean compareNumbers(List<Integer> playerNumbers, List<Integer> computerNumbers){
        initCount();
        checkStrikeAndBall(playerNumbers, computerNumbers);
        messagePrintBallAndStrike();
        return strikeCount == 3;
    }

    public void messagePrintBallAndStrike(){
        String message = "";
        message += getBallHintMessage();
        message += getStrikeHintMessage();
        message += getNotingHintMessage();
        outputView.printMessage(message);
    }

    public String getNotingHintMessage(){
        if(ballCount == 0 && strikeCount == 0){
            return NOTHING_MESSAGE;
        }
        return "";
    }

    public String getBallHintMessage(){
        if(ballCount > 0){
            return ballCount + BALL_MESSAGE + SPACING_MESSAGE;
        }
        return "";
    }

    public String getStrikeHintMessage(){
        if(strikeCount > 0){
            return strikeCount + STRIKE_MESSAGE + SPACING_MESSAGE;
        }
        return "";
    }

    public void initCount(){
        strikeCount = 0;
        ballCount = 0;
    }

    private void checkStrikeAndBall(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        for (int i = 0; i < BASEBALL_GAME_NUMBER_LENGTH; i++) {
            countStrike(computerNumbers.get(i), playerNumbers.get(i));
            countBall(computerNumbers, playerNumbers.get(i), i);
        }
    }

    public void countBall(List<Integer> computerNumbers, int playerNumber, int index){
        if(computerNumbers.get(index) != playerNumber && computerNumbers.contains(playerNumber)){
            ballCount++;
        }
    }

    public void countStrike(int computerNumber, int playerNumber){
        if(computerNumber == playerNumber){
            strikeCount++;
        }
    }
}
