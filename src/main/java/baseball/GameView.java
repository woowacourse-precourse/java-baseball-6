package baseball;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.BaseballGame.createRandomNumber;
import static baseball.BaseballGame.stringToList;


public class GameView {
    public static void Game() {
        BaseballGame baseballGame = new BaseballGame();
        Exception exception = new Exception();

        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        List<Integer> randomNumber = baseballGame.createRandomNumber();
        System.out.println(input);
        exception.checkInputNumber(input);

        List<Integer> inputNumberList = baseballGame.stringToList(input);





    }

}
