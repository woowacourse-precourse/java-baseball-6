package baseball.controller;


import baseball.domain.GameNumber;
import baseball.view.OutputView;

public class ComputerController {
    private static final int GAME_NUMBER_LENGTH = 3;
    private static final int GAME_SUCCESS_STRIKE_COUNT = 3;
    private static final int INIT_ZERO = 0;
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String NULL_MESSAGE = "";
    private static final String SPACING_MESSAGE = " ";
    private int strikeCount;
    private int ballCount;
    RandomNumberController randomNumberController = new RandomNumberController();
    OutputView outputView = new OutputView();

    public GameNumber startGame(){
        return randomNumberController.generateGameNumber();
    }

    public boolean proceedTodo(GameNumber computerNumber, GameNumber playerNumber){
        initZero();
        countStrikeAndBall(computerNumber, playerNumber);
        provideHint();
        return isThreeStrike();
    }

    private void initZero(){
        strikeCount = INIT_ZERO;
        ballCount = INIT_ZERO;
    }

    private void countStrikeAndBall(GameNumber computerNumber, GameNumber playerNumber){
        for (int i = 0 ; i < GAME_NUMBER_LENGTH; i++){
            countStrike(computerNumber.get(i), playerNumber.get(i));
            countBall(computerNumber, playerNumber.get(i), i);
        }
    }

    private void countStrike(int computerNumber, int playerNumber){
        if (computerNumber == playerNumber){
            strikeCount++;
        }
    }

    private void countBall(GameNumber gameNumber, int playerNumber, int playerIndex){
        if (!gameNumber.validate(playerNumber) && gameNumber.get(playerIndex) != playerNumber){
            ballCount++;
        }
    }

    private void provideHint(){
        outputView.printHint(makeHintMessage());
    }


    private String makeHintMessage(){
        String hintMessage = "";

        hintMessage += getBallHintMessage();
        hintMessage += getStrikeHintMessage();
        hintMessage += getNothingHintMessage();

        return hintMessage;
    }


    private String getBallHintMessage(){
        if (ballCount > 0){
            return ballCount + BALL_MESSAGE + SPACING_MESSAGE;
        }
        return NULL_MESSAGE;
    }

    private String getStrikeHintMessage(){
        if (strikeCount > 0){
            return strikeCount + STRIKE_MESSAGE + SPACING_MESSAGE;
        }
        return NULL_MESSAGE;
    }

    private String getNothingHintMessage(){
        if (ballCount == 0 && strikeCount == 0){
            return NOTHING_MESSAGE;
        }
        return NULL_MESSAGE;
    }

    private boolean isThreeStrike(){
        return strikeCount == GAME_SUCCESS_STRIKE_COUNT;
    }

}
