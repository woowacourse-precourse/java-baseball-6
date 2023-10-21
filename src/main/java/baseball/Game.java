package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {

    private final Computer computer;

    public Game () {
        computer = new Computer();
    }

    public void start() {
        while (true) {
            //한 게임 하는 사이클
            Round round = new Round(computer);
            if (round.getRoundResult()){break;}
        }
    }
}
