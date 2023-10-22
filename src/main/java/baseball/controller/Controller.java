package baseball.controller;

import baseball.function.RandomNum;
import baseball.value.ResultNum;
import baseball.function.GetUserNumber;

public class Controller {
    ResultNum resultNum;
    RandomNum randomNum = new RandomNum();
    GetUserNumber userNumber = new GetUserNumber();


    public void GameSetting() {

        resultNum = new ResultNum(randomNum.SetRandomNum());
        userNumber.getuserNumber();

    }
}