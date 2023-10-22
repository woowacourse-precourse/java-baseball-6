package baseball.controller;

import baseball.function.RandomNum;
import baseball.value.GameCount;
import baseball.value.ResultNum;
import baseball.function.GetUserNumber;
import baseball.function.Rule;
import baseball.view.Message;

public class Controller {
    ResultNum resultNum = new ResultNum();
    RandomNum randomNum = new RandomNum();
    GetUserNumber userNumber = new GetUserNumber();

    Message message = new Message();

    GameCount gameCount = new GameCount();
    Rule rule;

    public void run(){
        GameSetting();
        play();
        reGame();
    }

    public void GameSetting() {
        resultNum.setComputerNum(randomNum.getRandomNum());
        this.rule = new Rule(resultNum, gameCount);
    }
    public void play(){
        boolean isWrong = true;
        while(true){
            gameCount.initGame();
            resultNum.setUserNumber(userNumber.getUserNumber());
            rule.checkMatches();
            message.scoreMessage(gameCount.getBall(), gameCount.getStrike());

            if (gameCount.getStrike() == 3){
                message.gameWinMessage();
                break;
            }
        }
    }
    public void reGame(){
        Message.reGame();
        if(rule.checkReGame()){
            run();
        }
    }
}