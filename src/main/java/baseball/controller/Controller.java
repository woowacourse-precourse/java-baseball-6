package baseball.controller;

import baseball.function.RandomNum;
import baseball.value.ResultNum;

public class Controller {
    ResultNum resultNum;
    RandomNum randomNum = new RandomNum();


    public void GameSetting() {

        resultNum = new ResultNum(randomNum.SetRandomNum());
//        System.out.println(resultNum);

    }
}