package controller;

import static model.GameMaker.createGameMaker;
import static view.InputView.getUserNumbersInput;

import java.util.List;
import vo.UserNumbers;

public class BaseballController {

    public static void gameStart() {
        UserNumbers userNumbersInput = getUserNumbersInput();
        List<Integer> answer = createGameMaker();
    }
}
