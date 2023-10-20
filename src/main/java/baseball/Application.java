package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        int inputFew = 3; //몇자리 야구 게임

        BaseballGame baseballGame = new BaseballGame(inputFew);

        while (baseballGame.startGame()) ;

    }




}
