package baseball.controller;

import baseball.function.RandomNum;
import baseball.value.GameCount;
import baseball.value.ResultNum;
import baseball.function.GetUserNumber;
import baseball.function.Rule;

public class Controller {
    ResultNum resultNum = new ResultNum();
    RandomNum randomNum = new RandomNum();
    GetUserNumber userNumber = new GetUserNumber();

    GameCount gameCount = new GameCount();
    Rule rule;

    public void GameSetting() {
        resultNum.setComputerNum(randomNum.getRandomNum());
        this.rule = new Rule(resultNum);
    }
    public void play(){
        for(int i =0;i<100;i++){

            resultNum.setUserNumber(userNumber.getUserNumber());
            rule.checkMatches();
            System.out.println("qeqeqeqe");
        }
    }
    public void setGame(){

    }
}