package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static baseball.Constant.*;
import static baseball.Notification.*;

public class PlayNumberBaseBallGame {

    private static Scanner scanner = new Scanner(System.in);
    private static int strike;
    private static int ball;
    private static int nothing;

    public static void start(){
        System.out.println(Notification.START_GAME);
        String gameStatus = RESTART_GAME;
        while(gameStatus.equals(RESTART_GAME)){
            List<Integer> number = NumberGenerator.generateAnswerNumbers();
            playGame(number);
            System.out.println(RESTART_OR_STOP_GAME);
            gameStatus = scanner.next();
            Validator.checkEndOrRestart(gameStatus);
        }
    }

    private static void playGame(List<Integer> answer) {
        initStatus();
        while(strike < BALL_SIZE){
            initStatus();
            System.out.println(INPUT_NUMBER);
            compareNumbers(answer, getPlayerAnswer());
            displayResult();
        }
    }

    private static List<Integer> getPlayerAnswer() {
        String playerAnswer = scanner.next();
        /* 입력으로 받으면 안 되는 예외 사항 총 처리 */
        Validator.checkAllException(playerAnswer);

        List<Integer> playerAnswerList = new ArrayList<>();
        for(int i = 0;i < BALL_SIZE; ++i){
            playerAnswerList.add(playerAnswer.charAt(i) - '0');
        }
        return playerAnswerList;
    }

    private static void initStatus(){
        strike = 0;
        ball = 0;
        nothing = 0;
    }
}
