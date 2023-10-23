package baseball;
import static baseball.Constants.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args){
        System.out.println(startGameMessage);
        while (true) {
            Game baseBallGame = new Game();
            baseBallGame.play();
            System.out.println(continueGameMessage);
            String continueGame = Console.readLine();
            if (continueGame.equals("2")) { // TODO: error handle
                System.out.println(endGameMessage);
                break;
            }
        }
    }
}
