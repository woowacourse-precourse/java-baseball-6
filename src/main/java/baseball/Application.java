package baseball;
import static baseball.Constants.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public  static  boolean askGameContinue(){
        System.out.println(continueGameMessage);
        String continueCommand = Console.readLine(); // TODO: error handle
        if (continueCommand.equals(gameContinue)) {
            System.out.println(endGameMessage);
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(startGameMessage);
        while (true) {
            Game baseBallGame = new Game();
            baseBallGame.play();
            if(askGameContinue()) break;
        }
    }
}
