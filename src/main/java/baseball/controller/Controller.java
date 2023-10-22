package baseball.controller;

import baseball.function.RandomNum;
import baseball.value.ResultNum;
import baseball.function.GetUserNumber;
import baseball.function.Rule;

public class Controller {
    ResultNum resultNum = new ResultNum();
    RandomNum randomNum = new RandomNum();
    GetUserNumber userNumber = new GetUserNumber();


    public void GameSetting() {
        resultNum.setComputerNum(randomNum.getRandomNum());
        resultNum.setUserNumber(userNumber.getUserNumber());
    }




    public void setGame(){


    }
}