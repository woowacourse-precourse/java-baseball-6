package baseball.controller;

import baseball.model.NumberModel;
import baseball.utils.RandomUtil;

public class GameController {
    NumberModel numberModel = new NumberModel();
    RandomUtil randomUtil = new RandomUtil();

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        numberModel.setComputerNumbers(randomUtil.createRandomList());

    }

}
