package baseball;
import java.util.*;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현
        BaseballGame b = new BaseballGame();

        b.startGame();
        while(true) {
            List<Integer> randomNum = b.getRandomNum();
            while (true) {
                List<Integer> userNum = b.getUserInput();
                b.compareNum(randomNum,userNum);
                int strike = b.printHint();
                if (strike == 3)
                    break;
            }
            int userChoice = b.continueGame();
            if(userChoice == 2)
                break;
        }
    }
}


