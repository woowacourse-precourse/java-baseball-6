package baseball;

import java.util.*;
import java.util.stream.Collectors;

import baseball.controller.BaseballController;
import baseball.model.GameNumber;
import baseball.view.Message;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computerNumber = GameNumber.randomNumberGenerator();
        Message.gameStart();
        BaseballController.playGame(computerNumber);
    }


}

