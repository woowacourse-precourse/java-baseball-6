package baseball;

import baseball.View.BaseballGame;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static void main(String[] args) {
        BaseballGame baseballGame= new BaseballGame();

        baseballGame.run();
    }
}
