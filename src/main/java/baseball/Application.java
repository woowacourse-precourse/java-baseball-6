package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> randomNumber = RandomNumberMaker.makeRandomNumber();

        System.out.println(randomNumber);
        try {
            GameHost.startGame(randomNumber);
        } catch (IllegalArgumentException e) {
            throw e;
        }


    }


}
