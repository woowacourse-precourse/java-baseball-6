package baseball;

import baseball.Controller.GameController;
import baseball.Service.CompareNumberService;
import baseball.Service.RandomGenerator;
import baseball.View.Input;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        String randomNum = RandomGenerator.getRandomNumber();
        String userNum = Input.inputUserNumber();


    }

}