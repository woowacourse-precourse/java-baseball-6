package baseball.logic;

import baseball.controller.PlayerController;
import baseball.controller.PlayerControllerImpl;
import baseball.view.GameView;

public class BaseBallGame implements Game {
    private final GameView view;
    private final PlayerController playerController;
    private final int NUMBER_SIZE;
    private boolean running = true;
    public BaseBallGame(GameView view, PlayerController playerController, int numberSize) {
        this.view = view;
        this.playerController = playerController;
        this.NUMBER_SIZE = numberSize;
    }
    @Override
    public boolean restart() {
        String restart = view.getRestart();
        if (restart.equals("2")){
            return false;
        }
        return true;
    }
    @Override
    public void start() {
        view.printStart();
        while(running){
            run();
            running = restart();
        }
    }
    @Override
    public void run(){
        playerController.reset(NUMBER_SIZE);
        while(true){
            String userInput = view.getInputNumber();
            isValidate(userInput);
            int strike = getScore(userInput);
            if (strike == NUMBER_SIZE){
                break;
            }
        }
        exit();
    }
    @Override
    public void exit() {
        view.printExit();
    }
    public int getScore(String userInput){
        int strikeCount = playerController.getStrikeCount(userInput);
        int ballCount = playerController.getBallCount(userInput);

        if (strikeCount > 0 && ballCount > 0) {
            view.printBothScore(ballCount, strikeCount);
        }else if (strikeCount > 0){
            view.printStrikeScore(strikeCount);
        }else if (ballCount > 0){
            view.printBallScore(ballCount);
        }else if (strikeCount == 0 && ballCount == 0){
            view.printNoneScore();
        }else if (strikeCount == NUMBER_SIZE){
            view.printStrikeScore(strikeCount);
        }
        return strikeCount;
    }
    private String isValidate(String userInput){
        if (userInput.length() != NUMBER_SIZE || userInput.contains("0") ||
                userInput.charAt(0) == userInput.charAt(1) || userInput.charAt(1) == userInput.charAt(2) || userInput.charAt(0) == userInput.charAt(2)){
            throw new IllegalArgumentException();
        }
        return userInput;
    }
}