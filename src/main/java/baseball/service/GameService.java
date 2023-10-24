package baseball.service;

import baseball.model.Game;
import baseball.view.EndView;
import baseball.view.StartView;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class GameService {

    public Game createGame(){
        StartView.printGameStart();
        int[] answerArray = createAnswerArray();
        return new Game(answerArray);
    }

    public static int[] createAnswerArray(){
        int[] answerArray = new int[3];
        for(int i=0; i<3; i++){
            answerArray[i] = Randoms.pickNumberInRange(1,9);
            for(int prev=0; prev<i; prev++){
                if(answerArray[prev]==answerArray[i]){
                    i--;
                    break;
                }
            }
        }
        return answerArray;
    }

    public static boolean isEnd(){
        EndView.printGameRestartDescription();
        String exitType = Console.readLine();
        if(exitType.equals("2")) return true;
        else if (exitType.equals("1")) return false;
        else throw new IllegalArgumentException();
    }
}
