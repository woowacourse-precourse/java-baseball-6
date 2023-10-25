package baseball;

import baseball.game.Game;
import baseball.game.NumberBaseballGameImpl;
import baseball.gameMachine.GameMachine;
import baseball.gameMachine.GameMachineImpl;
import baseball.user.User;
import baseball.user.UserImpl;


public class Application {
    public static void main(String[] args) {

        User user = new UserImpl();
        Game game = new NumberBaseballGameImpl();
        GameMachine gameMachine = new GameMachineImpl(user, game);
        gameMachine.runGame();


    }




}


