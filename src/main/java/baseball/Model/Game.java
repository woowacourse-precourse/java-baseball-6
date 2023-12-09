package baseball.Model;

import baseball.Controller.Array;
import java.util.ArrayList;

import static baseball.Constants.*;
import static baseball.View.InputView.*;
import static baseball.View.OutputView.*;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    ArrayList<Integer> compareNumList = new ArrayList<>();

    public Game() {
        setRandomNum();
    }

    private Game(String str){
        for(int i = 0; i < NUM_SIZE;  i++){
            compareNumList.add(Integer.parseInt(str.charAt(i) + ""));
        }
    }

    private void setRandomNum() {
        int numIdx = 0;
        while(numIdx < NUM_SIZE){
            int randNum = getRandomNum();
            if(!Array.checkArrayContains(compareNumList, randNum)){
                compareNumList.add(randNum);
                numIdx++;
            }
        }
    }
    private int getRandomNum() {
        return pickNumberInRange(NUM_START, NUM_END);
    }

    public static void init(Game correctAnswer){
        Game answer = new Game(readAnswer());
        Hint hint = new Hint();
        hint.compareAns(answer, correctAnswer);
        hint.setCount();

        if(hint.strike != ALL_CORRECT){
            Game.init(correctAnswer);
            return;
        }

        if(printRetry() == GAME_RESTART) {
            correctAnswer = new Game();
            Game.init(correctAnswer);
        }
    }

    public static int getNewGameAnswer(String str){
        int intVal;
        try {
            intVal = Integer.parseInt(str);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        return intVal;
    }
}
