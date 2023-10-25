package baseball.controller;

import baseball.service.BaseballService;
import baseball.view.BaseballPrint;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {
    final int SIZE = 3;
    final int START = 1;
    final int END = 9;
    final int RETRY = 1;
    final int GAME_OVER = 2;
    BaseballService baseballService = new BaseballService();
    BaseballPrint baseballPrint = new BaseballPrint();

    public void run(){
        setGame();
        playGame();
        endGame();
        askRetry();
    }

    private void setGame(){
        baseballService.setGame(SIZE, START, END);
    }

    private void playGame(){
        baseballService.playGame();
    }

    private void endGame(){
        baseballPrint.printEndMent();
    }

    private void askRetry(){
        baseballPrint.printRetryMent();
        if(getInputNum() == RETRY){
            run();
        }
    }

    private int getInputNum() throws IllegalArgumentException {
        int inputNum = Integer.parseInt(Console.readLine());

        if (inputNum == 0 || inputNum > GAME_OVER) {
            throw new IllegalArgumentException();
        }
        return inputNum;
    }
}
