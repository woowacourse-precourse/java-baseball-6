package baseball;
import static baseball.Constants.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public  static  boolean askGameContinueOrStop(){
        System.out.println(continueGameMessage);
        String isContinueGame = Console.readLine(); // TODO: error handle
        if (isContinueGame.equals(gameContinue)) {
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
            if(askGameContinueOrStop()) break;
        }
    }
}
