package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static Game game = new Game();
    public static void main(String[] args) {
        do{
            game.start();

        }while(game.restart()==true);
    }
}
