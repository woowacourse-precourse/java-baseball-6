package baseball;

import java.util.List;
import java.util.Scanner;

import static baseball.Constant.*;
import static baseball.Notification.*;

public class PlayNumberBaseBallGame {

    private static Scanner scanner = new Scanner(System.in);
    private static int strike;
    private static int ball;
    private static int nothing;

    public static void play(){
        System.out.println(Notification.START_GAME);
        String gameStatus = RESTART_GAME;
        while(gameStatus.equals(RESTART_GAME)){
            List<Integer> number = NumberGenerator.generateAnswerNumbers();
            initStatus();
            for(int i=0;i<3;++i) System.out.print(number.get(i));
            playGame(number);
            System.out.println(RESTART_OR_STOP_GAME);
            gameStatus = scanner.next();
            Validator.checkEndOrRestart(gameStatus);
        }
    }

}
