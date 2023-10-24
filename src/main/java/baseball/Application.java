package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Constants.*;

public class Application {

    private static int restartInput(){
        System.out.println(RESTART_GAME_OR_NOT);
        int execInput = Integer.parseInt(Console.readLine());

        if (!(execInput == 1 || execInput == 2)){
            throw new IllegalArgumentException(CHOICE_ONE_OR_TWO);
        }
        return execInput;
    }

    public static void main(String[] args) {

        System.out.println(START_GAME);
        int execInput = 1;
        while (execInput == 1){

            Game game = new Game();
            game.play();

            execInput = restartInput();
        }
    }

}
